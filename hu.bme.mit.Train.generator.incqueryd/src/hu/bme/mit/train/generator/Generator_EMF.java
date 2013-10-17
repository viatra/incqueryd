package hu.bme.mit.train.generator;

import hu.bme.mit.train.util.FileBroker2;
import hu.bme.mit.train.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Concept.ConceptFactory;
import Concept.IndividualContainer;
import Concept.Route;
import Concept.Segment;
import Concept.Sensor;
import Concept.Signal;
import Concept.SignalStateKind;
import Concept.Switch;
import Concept.SwitchPosition;
import Concept.SwitchStateKind;
import Concept.Trackelement;

/**
 * Generate the EMF instance model.
 */
@RunWith(Parameterized.class)
public class Generator_EMF implements IGenerator {

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
				{1} , {2}, {4}, {8}, {16}, {32}, {64}, {128}, {256}, {512}
		};
		return Arrays.asList(data);
	}
	
	private GeneratorConfig generatorConstants;
	private Resource resource;
	
	private long number;

	public void initModel() {

		// ************ BACKEND INIT ************

		initFiles();
		
		String uuidStr = generatorConstants.genUUID ? "UUID_" : "";
		
		URI resourceURI = FileBroker2.getEMFUri(generatorConstants.instanceModelPath + "/testBig" + generatorConstants.variant + uuidStr + generatorConstants.Size + ".concept");
		
		if (generatorConstants.genUUID) {
			Util.registerUUIDXMIResourceFactory();
		}
		
		ResourceSet resourceSet = new ResourceSetImpl();
		
		if ("B".equals(generatorConstants.variant)) {
			Resource.Factory binaryResourceFactory = new Resource.Factory()
			{
				public Resource createResource(URI uri) {
					return new BinaryResourceImpl(uri);
				}
			};
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("concept", binaryResourceFactory);
			resource = resourceSet.createResource(URI.createFileURI(resourceURI.path()));
		} else
		{
			resource = resourceSet.createResource(resourceURI);
		}

		// ************ TESTCASE related ************

		resource.getContents().clear();
	}

	public void initFiles() {
		//FileCopy.copy(RuntimeConstants.projectPath + "/models/testBig.concept.clear",
		//		RuntimeConstants.modelProjectPath + "/models/testBig.concept");
	}

	public void persistModel() {
		
		try {
			resource.save(null);
			//FileCopy.move(RuntimeConstants.modelProjectPath + "/models/testBig.concept",
			//	      RuntimeConstants.modelProjectPath + "/models/testBig" + generatorConstants.variant + uuidStr + generatorConstants.Size + ".concept");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	@Override
	public void testFillUpFile(GeneratorConfig generatorConstants) {
		this.generatorConstants = generatorConstants;
		initModel();
		
		ConceptFactory factory = ConceptFactory.eINSTANCE;
		Random random = new Random(generatorConstants.RANDOM);
		int rnd;
		number = 0;

		for (int l = 0; l < generatorConstants.MAX_IndividualContainer; l++) {
			
			//EMF
			IndividualContainer cont = factory.createIndividualContainer();
			number++;
			resource.getContents().add(cont);
			
			Signal prevSig = null;
			Signal firstSig = null;
			ArrayList<Trackelement> firstTracks = null;
			ArrayList<Trackelement> prevTracks = null;
			
			for (int i = 0; i < generatorConstants.MAX_Routes; i++) {

				Route route = factory.createRoute();
				number++;
				cont.getContains().add(route);

				if (prevSig==null)
				{
					prevSig = factory.createSignal();
					firstSig = prevSig;
					number++;
					cont.getContains().add(prevSig);
					prevSig.setSignal_actualState(SignalStateKind.SIGNAL_STATE_KIND_GO);
				}

				Signal sig2;
				if (i!=generatorConstants.MAX_Routes - 1)
				{
					sig2 = factory.createSignal();
					number++;
					sig2.setSignal_actualState(SignalStateKind.SIGNAL_STATE_KIND_GO);
					cont.getContains().add(sig2);
				} else
					sig2=firstSig;
				
				rnd = random.nextInt(100);
				if (rnd>=generatorConstants.signalNeighborErrorPercent)
					route.setRoute_entry(prevSig);

				rnd = random.nextInt(100);
				if (rnd>=generatorConstants.signalNeighborErrorPercent)
					route.setRoute_exit(sig2);
				
				int swps = random.nextInt(generatorConstants.MAX_SwPs);
				
				ArrayList<Trackelement> currTracks = new ArrayList<Trackelement>();
				
				for (int j=0; j < swps; j++)
				{
					Switch sw = factory.createSwitch();
					number++;
					cont.getContains().add(sw);
					currTracks.add(sw);

					int sensors = random.nextInt(generatorConstants.MAX_Sensors);
					
					for (int k=0; k < sensors; k++)
					{
						Sensor sen = factory.createSensor();
						number++;
						
						cont.getContains().add(sen);

						rnd = random.nextInt(100);
						if (rnd>=generatorConstants.switchSensorErrorPercent)
						{
							sw.getTrackElement_sensor().add(sen);
							
							int rnd2 = random.nextInt(100);
							if (rnd2>=generatorConstants.routeSensorErrorPercent)
							{
								route.getRoute_routeDefinition().add(sen);
							}
						}
						
						for (int m = 0; m < generatorConstants.MAX_Segments; m++) {

							int value;
							rnd = random.nextInt(100);
							
							if (rnd<generatorConstants.posLengthErrorPercent)
								value = -1 * random.nextInt(1000);
							else
								value = random.nextInt(1000);
							
							Segment seg = factory.createSegment();
							number++;
							seg.setSegment_length(value);
							seg.getTrackElement_sensor().add(sen);
							cont.getContains().add(seg);
							currTracks.add(seg);
						}
					}
					
					SwitchPosition swp = factory.createSwitchPosition();
					number++;
					cont.getContains().add(swp);

					swp.setSwitchPosition_switch(sw);

					int state = random.nextInt(4);
					 
					rnd = random.nextInt(100);
					if (rnd<generatorConstants.switchSetErrorPercent)
					{
						sw.setSwitch_actualState(SwitchStateKind.get(state));

						swp.setSwitchPosition_switchState(SwitchStateKind.get(3-state));
					} else
					{
						sw.setSwitch_actualState(SwitchStateKind.get(state));

						swp.setSwitchPosition_switchState(SwitchStateKind.get(state));
					}
					
					route.getRoute_switchPosition().add(swp);
					
				}
				
				Trackelement prevte = null;
				for (Trackelement trackelement : currTracks) {
					if (prevte!=null)
						prevte.getTrackElement_connectsTo().add(trackelement);
					prevte=trackelement;
				}
				
				if (prevTracks!=null && prevTracks.size()>0 && currTracks.size()>0)
					prevTracks.get(prevTracks.size()-1).getTrackElement_connectsTo().add(currTracks.get(0));
				
				
				//Loop the last track element of the last route to the first track element of the first route.
				if (i==generatorConstants.MAX_Routes - 1)
				{
					if (currTracks!=null && currTracks.size()>0 && firstTracks.size()>0)
						currTracks.get(currTracks.size()-1).getTrackElement_connectsTo().add(firstTracks.get(0));
				}
				
				
				if (prevTracks==null)
					firstTracks=currTracks;

				prevTracks=currTracks;
				prevSig=sig2;
				//System.out.println("Route"+i+" done.");
			}
			
			
		}
		System.out.println(number);

		persistModel();
		System.out.println("Done");
	}

}
