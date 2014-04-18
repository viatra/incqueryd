package hu.bme.mit.incqueryd.tooling.scriptgenerator

import akka.actor.ActorSystem
import akka.actor.Address
import akka.actor.Deploy
import akka.actor.Props
import akka.remote.RemoteScope
import arch.Configuration
import hu.bme.mit.incqueryd.tooling.actors.IncQueryDKernel.ReteActor
import infrastructure.Machine
import java.util.ArrayList
import org.eclipse.core.resources.IFile
import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe

class Generator {

	val system = ActorSystem.create("incqueryd-local")

	public def generateScripts(IFile file, Configuration configuration) {
		val fileName = "deploy.sh"
		val scriptPath = FileHandler.writeFileToProject(file, fileName, generateScript(file, configuration))
		
		println(scriptPath.toString)
		
		val builder = new ProcessBuilder("/bin/bash", scriptPath.toString)
		val process = builder.start
		process.waitFor
				
		println("deploying actors")
//		configuration.deployActors
		system.shutdown
	}

	def CharSequence generateScript(IFile file, Configuration configuration) {
		val machines = new ArrayList<String>

		configuration.clusters.forEach [
			println("# Cluster: " + it.traceInfo)
			val nodes = it.infrastructureNodes
			nodes.forEach [
				
				if (it instanceof Machine) {
					val m = it as Machine
					machines.add(m.ip)
					
					FileHandler.writeFileToProject(file, "application.conf-" + m.ip, m.generateConfiguration)					
				}
			]
		]

		val machineList = machines.join(" ")
		val configurationFilePath = FileHandler.generateFileHandle(file, "application.conf").rawLocation.toString
		println(configurationFilePath);
		

		'''
		#!/bin/bash
		
		user=szarnyasg
		machines=(«machineList»)
		akkadir=akka-2.2.3
		
		for ((i = 0; i < ${#machines[@]}; ++i))
		do
			machine=${machines[i]}
			echo $machine
		
			scp «configurationFilePath»-$machine $user@$machine:$akkadir/config/application.conf
		    ssh $user@$machine "pkill -f akka"
		done
		sleep 3
		
		for ((i = 0; i < ${#machines[@]}; ++i))
		do
			machine=${machines[i]}
			echo $machine
		
		    ssh $user@$machine "nohup ~/$akkadir/bin/akka hu.bme.mit.incqueryd.tooling.actors.IncQueryDKernel > akka.out 2> akka.err < /dev/null &"
		done
		sleep 3
		'''
	}

	def CharSequence generateConfiguration(Machine machine) {
		'''
		akka {
		  actor {
		    provider = "akka.remote.RemoteActorRefProvider"    
		  }
		  
		  remote {
		    enabled-transports = ["akka.remote.netty.tcp"]
		    netty.tcp {
		      hostname = "«machine.ip»"
		      port = 2554
		    }
		  }
		}
		'''
	}

	def void deployActors(Configuration configuration) {
		configuration.mappings.forEach [
			println(it)
			if (it.targetElement instanceof Machine) {
				val m = it.targetElement as Machine

				// only inspect concrete classes
				it.mappedElements.forEach [
					switch (it) {
						AntiJoinRecipe: antiJoin(m, it)
						JoinRecipe: join(m, it)
						ProductionRecipe: production(m, it)
						UniquenessEnforcerRecipe: uniquenessEnforcer(m, it)
						TrimmerRecipe: trimmer(m, it)
					}
				]
			}
		]

		Thread.sleep(2000)
	}

	def void deploy(Machine m, Object msg) {
		val addr = new Address("akka.tcp", "incqueryd-kernel", m.ip, 2554)
		val ref = system.actorOf(Props.create(typeof(ReteActor)).withDeploy(new Deploy(new RemoteScope(addr))))
		ref.tell(msg, system.deadLetters)
		System.out.println("Actor deployed: " + ref)
	}

	def void antiJoin(Machine m, AntiJoinRecipe recipe) {
		deploy(m, "AntiJoin node")
	}

	def void join(Machine m, JoinRecipe recipe) {
		deploy(m, "Join node")
	}

	def void production(Machine m, ProductionRecipe recipe) {
		deploy(m, "Production node")
	}

	def void uniquenessEnforcer(Machine m, UniquenessEnforcerRecipe recipe) {
		deploy(m, "UniquenessEnforcer node")
	}

	def void trimmer(Machine m, TrimmerRecipe recipe) {
		deploy(m, "Trimmer node")
	}

}
