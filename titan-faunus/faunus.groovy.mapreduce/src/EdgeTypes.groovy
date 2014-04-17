import com.thinkaurelius.titan.core.TitanFactory
import com.tinkerpop.blueprints.Graph
import org.apache.commons.configuration.BaseConfiguration

Graph g

hostName = "localhost"
//edgeType = "father";
//v2Types = ["titan", "human"];

edgeType = "ROUTE_ROUTEDEFINITION";
v2Types = ["Sensor"];

def setup(args) {
	conf = new BaseConfiguration()
	conf.setProperty("storage.backend", args[0])
	conf.setProperty("storage.hostname", hostName)
	g = TitanFactory.open(conf)
}

def map(v, args) {
	v1 = g.v(v.id) // the Faunus vertex id is the same as the original Titan vertex id
	pipe = v1.outE(edgeType).inV

	def list = []
	while (pipe.hasNext()) {
		v2 = pipe.next()
		if (v2.type in v2Types) {
			list << v2.id
		}
	}
	def pair = [v1.id, list]
}

def cleanup(args) {
	g.shutdown()
}
