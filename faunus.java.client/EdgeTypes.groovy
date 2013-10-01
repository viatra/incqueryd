import com.thinkaurelius.titan.core.TitanFactory
import com.tinkerpop.blueprints.Graph
import org.apache.commons.configuration.BaseConfiguration

Graph g

hostname = "localhost"
edgeTypes = [
	"SWITCHPOSITION_SWITCH",
	"ROUTE_SWITCHPOSITION",
	"TRACKELEMENT_SENSOR",
	"ROUTE_ROUTEDEFINITION",
]

def setup(args) {
	conf = new BaseConfiguration()
	conf.setProperty("storage.backend", args[0])
	conf.setProperty("storage.hostname", hostname)
	conf.setProperty("storage.batch-loading", true);
	g = TitanFactory.open(conf)
}

def map(v, args) {
	// the Faunus vertex id is the same as the original Titan vertex id
	v1 = g.v(v.id)
	// create the list for the adjacent vertices
	v1List = []

	// collecting each edgetype
	for (edgeType in edgeTypes) {
		v1List << edgeType
		
		pipe = v1.outE(edgeType).inV
		def currentEdgeTypeList = []
		while (pipe.hasNext()) {
			v2 = pipe.next()
			currentEdgeTypeList << v2.id
		}
		
		v1List << currentEdgeTypeList
	}

	v1.id + ": " + v1List
}

def cleanup(args) {
	g.shutdown()
}
