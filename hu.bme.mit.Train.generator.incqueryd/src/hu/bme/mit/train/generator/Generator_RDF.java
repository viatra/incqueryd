package hu.bme.mit.train.generator;

import hu.bme.mit.train.common.RuntimeConstants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openrdf.OpenRDFException;
import org.openrdf.model.Literal;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.rdfxml.RDFXMLWriter;
import org.openrdf.sail.memory.MemoryStore;

/**
 * Generate the Ontology instance model.
 */
@RunWith(Parameterized.class)
public class Generator_RDF implements IGenerator {
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
				{1}, {2}, {4}, {8}, {16}, {32}, {64}, {128}, {256}, {512}
		};
		return Arrays.asList(data);
	}
	private GeneratorConfig generatorConstants;
	
	private String ontologyIRI = "http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl";
	private RepositoryConnection con;
	private Repository myRepository;
	private ValueFactory vf;


	private long number;

	public void initModel() {

		// ************ BACKEND INIT ************
		
		// Init ontology
		try {
			File documentFile;
			if (generatorConstants.getMetamodel() == 1) {
				documentFile = new File(RuntimeConstants.projectPath + "/models/testBig_noMM.owl.clear");
			} else {
				documentFile = new File(RuntimeConstants.projectPath + "/models/testBig.owl.clear");
			}

			myRepository = new SailRepository(new MemoryStore());
			myRepository.initialize();

			con = myRepository.getConnection();
			con.add(documentFile, ontologyIRI, RDFFormat.RDFXML);
			
			vf = con.getValueFactory();
		}
		catch (OpenRDFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void persistModel() {
		try {
			con.commit();
			con.export(new RDFXMLWriter(new FileWriter("/home/szarnyasg/hdd/models/testBig" + generatorConstants.variant + generatorConstants.Size + (generatorConstants.getMetamodel() == 1?"_noMM":"") +".owl")));
			con.close();
			//FileCopy.move(RuntimeConstants.modelProjectPath + "/models/testBig.owl",
			//		RuntimeConstants.modelProjectPath + "/models/testBig" + RuntimeConstants.emfVariant + generatorConstants.Size + ".owl");
		} catch (RepositoryException e) {
			e.printStackTrace();
		} catch (RDFHandlerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected long id = 0;
	
	Resource addIndividual(String name, String type, Resource container, String relationName) {
		Resource owlIndividual = addIndividual(name, type);
		if (generatorConstants.getMetamodel() == 0)  // There is container (model object) only for mm=0. (This func. is only called when container is the container. : )
			addRelation(container, relationName, owlIndividual);
		return owlIndividual;
	}
	
	Resource addIndividual(String name, String type) {
		id++;
		//Resource owlIndividual = vf.createURI(ontologyIRI + "#" + name + "^" + id);
		Resource owlIndividual = vf.createURI(ontologyIRI + "#" + id);
		URI relation = vf.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
		Resource owlClass = vf.createURI(ontologyIRI + "#" + type);
		Statement stmt = vf.createStatement(owlIndividual, relation, owlClass);
		try {
			con.add(stmt, (Resource)null);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return owlIndividual;
	}
	
	void addRelation(Resource source, String relationName, Resource target) {
		URI relation = vf.createURI(ontologyIRI + "#" + relationName);
		Statement stmt = vf.createStatement(source, relation, target);
		try {
			con.add(stmt, (Resource)null);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

	void addDataRelation(Resource source, String relationName, int value) {
		URI relation = vf.createURI(ontologyIRI + "#" + relationName);
		Literal valueLiteral = vf.createLiteral(value);
		Statement stmt = vf.createStatement(source, relation, valueLiteral);
		try {
			con.add(stmt, (Resource)null);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Override
	public void testFillUpFile(GeneratorConfig generatorConstants) {
		this.generatorConstants = generatorConstants;
		initModel();
		
		
		Random random = new Random(generatorConstants.RANDOM);
		int rnd;
		number = 0;

		for (int l = 0; l < generatorConstants.MAX_IndividualContainer; l++) {

			//RDF
			Resource owl_cont = null;
			if (generatorConstants.getMetamodel() == 0)
				owl_cont = addIndividual("IndividualContainer" + l, "IndividualContainer");
			number++;

			
			Resource prevSig = null;
			Resource firstSig = null;
			ArrayList<Resource> firstTracks = null;
			ArrayList<Resource> prevTracks = null;

			int lastBlock = -1;
			Format f = new SimpleDateFormat("HH:mm:ss");
			for (int i = 0; i < generatorConstants.MAX_Routes; i++) {
				if (lastBlock < i/1000) {
					System.out.println(f.format(Calendar.getInstance().getTime()) + " " + i/1000 + "/" + generatorConstants.MAX_Routes/1000);
					lastBlock = i/1000;
				}
				Resource route = addIndividual("Route" + i, "Route", owl_cont, "IndividualContainer_Contains");
				number++;

				Resource signal_go_state = vf.createURI("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#SignalStateKind_GO");

				
				if (prevSig==null)
				{
					prevSig = addIndividual("Signal" + i + "a", "Signal", owl_cont, "IndividualContainer_Contains");
					firstSig = prevSig;
					number++;

					addRelation(prevSig, "Signal_actualState", signal_go_state);
				}

				Resource sig2;
				if (i!=generatorConstants.MAX_Routes - 1)
				{
					sig2 = addIndividual("Signal" + i + "b", "Signal", owl_cont, "IndividualContainer_Contains");
					number++;
					addRelation(sig2, "Signal_actualState", signal_go_state);
					
				} else
					sig2=firstSig;
				
				rnd = random.nextInt(100);
				if (rnd>=generatorConstants.signalNeighborErrorPercent)
					addRelation(route, "Route_entry", prevSig);

				rnd = random.nextInt(100);
				if (rnd>=generatorConstants.signalNeighborErrorPercent)
					addRelation(route, "Route_exit", sig2);
				
				int swps = random.nextInt(generatorConstants.MAX_SwPs);
				
				ArrayList<Resource> currTracks = new ArrayList<Resource>();
				
				for (int j=0; j < swps; j++)
				{
					Resource sw = addIndividual("Switch" + j + "_" + i, "Switch", owl_cont, "IndividualContainer_Contains");
					number++;

					currTracks.add(sw);

					int sensors = random.nextInt(generatorConstants.MAX_Sensors);
					
					for (int k=0; k < sensors; k++)
					{
						Resource sen = addIndividual("Sensor" + k + "_" + j + "_" + i, "Sensor", owl_cont, "IndividualContainer_Contains");						
						number++;
						
						
						rnd = random.nextInt(100);
						if (rnd>=generatorConstants.switchSensorErrorPercent)
						{
							addRelation(sw, "TrackElement_sensor", sen);
							
							int rnd2 = random.nextInt(100);
							if (rnd2>=generatorConstants.routeSensorErrorPercent)
							{
								addRelation(route, "Route_routeDefinition", sen);
							}
						}
						
						for (int m = 0; m < generatorConstants.MAX_Segments; m++) {

							int value;
							rnd = random.nextInt(100);
							
							if (rnd<generatorConstants.posLengthErrorPercent)
								value = -1 * random.nextInt(1000);
							else
								value = random.nextInt(1000);
							
							Resource seg = addIndividual("Segment" + m + "_" + k + "_" + j + "_" + i, "Segment", owl_cont, "IndividualContainer_Contains");
							number++;
							addDataRelation(seg, "Segment_length", value);
							addRelation(seg, "TrackElement_sensor", sen);

							currTracks.add(seg);
						}
					}
					
					Resource swp = addIndividual("SwitchPosition" + j + "_" + i, "SwitchPosition", owl_cont, "IndividualContainer_Contains");
					number++;


					addRelation(swp, "SwitchPosition_switch", sw);

					int state = random.nextInt(4);
					 
					URI switchStates[] = new URI[4];
					switchStates[0] = vf.createURI("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#PointStateKind_LEFT");
					switchStates[1] = vf.createURI("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#PointStateKind_STRAIGHT");
					switchStates[2] = vf.createURI("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#PointStateKind_RIGHT");
					switchStates[3] = vf.createURI("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#PointStateKind_FAILURE");
					 
					rnd = random.nextInt(100);
					if (rnd<generatorConstants.switchSetErrorPercent)
					{
						addRelation(sw, "Switch_actualState", switchStates[state]);

						addRelation(swp, "SwitchPosition_switchState", switchStates[3-state]);
					} else
					{
						addRelation(sw, "Switch_actualState", switchStates[state]);

						addRelation(swp, "SwitchPosition_switchState", switchStates[state]);
					}
					
					addRelation(route, "Route_switchPosition", swp);

				}

				Resource prevte = null;
				for (Resource trackelement : currTracks) {
					if (prevte!=null)
						addRelation(prevte, "TrackElement_connectsTo", trackelement);
					prevte=trackelement;
				}
				
				if (prevTracks!=null && prevTracks.size()>0 && currTracks.size()>0)
					addRelation(prevTracks.get(prevTracks.size()-1), "TrackElement_connectsTo", currTracks.get(0));
				
				
				//Loop the last track element of the last route to the first track element of the first route.
				if (i==generatorConstants.MAX_Routes - 1)
				{
					if (currTracks!=null && currTracks.size()>0 && firstTracks.size()>0)
						addRelation(currTracks.get(currTracks.size()-1), "TrackElement_connectsTo", firstTracks.get(0));
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
