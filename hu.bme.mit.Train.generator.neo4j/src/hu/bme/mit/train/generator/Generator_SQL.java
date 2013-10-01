package hu.bme.mit.train.generator;

import hu.bme.mit.train.common.RuntimeConstants;
import hu.bme.mit.train.util.FileCopy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * Generate the Ontology instance model.
 */
@RunWith(Parameterized.class)
public class Generator_SQL implements IGenerator {
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
				{1}, {2}, {4}, {8}, {16}, {32}//, {64}, {128}, {256}, {512}
		};
		return Arrays.asList(data);
	}
	private GeneratorConfig generatorConstants;
	

	private BufferedWriter file;
	private long number;
	private long signalid;
	private long teid;
	private long swpid;
	private long senid;

	

	public void initModel() {

		// ************ BACKEND INIT ************
		initFiles();
	}

	public void initFiles() {
		FileCopy.copy(RuntimeConstants.projectPath + "/models/testBig.sql",
				RuntimeConstants.modelProjectPath + "/models/testBig.sql");
		try {
			file = new BufferedWriter(new FileWriter(RuntimeConstants.modelProjectPath + "/models/testBig.sql",true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void persistModel() {
		try {
			file.close();
			FileCopy.move(RuntimeConstants.modelProjectPath + "/models/testBig.sql",
					RuntimeConstants.modelProjectPath + "/models/testBig" + generatorConstants.variant + generatorConstants.Size + ".sql");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(String s)
	{
		try {
			file.write(s+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Override
	public void testFillUpFile(GeneratorConfig generatorConstants) {
		this.generatorConstants = generatorConstants;
		initModel();
		
		Random random = new Random(generatorConstants.RANDOM);
		int rnd, rnd1, rnd2;
		number = 0;
		signalid = 0;
		swpid = 0;
		senid = 0;

		for (int l = 0; l < generatorConstants.MAX_IndividualContainer; l++) {

			//RDF
			long prevSig = 0;
			long firstSig = 0;
			ArrayList<Long> firstTracks = null;
			ArrayList<Long> prevTracks = null;

			for (int i = 0; i < generatorConstants.MAX_Routes; i++) {

				if (prevSig==0)
				{
					signalid++;
					prevSig = signalid; 
					write("INSERT INTO `Signals` (`id`, `Signal_actualState`) VALUES ("+signalid+",3);");
					firstSig = prevSig;
					number++;
				}

				Long sig2;
				if (i!=generatorConstants.MAX_Routes - 1)
				{
					signalid++;
					sig2 = signalid;
					write("INSERT INTO `Signals` (`id`, `Signal_actualState`) VALUES ("+signalid+",3);");
					number++;
				} else
					sig2=firstSig;
				
				rnd1 = random.nextInt(100);
				rnd2 = random.nextInt(100);
				int routeid=i+1;
				if (rnd1>=generatorConstants.signalNeighborErrorPercent)
				{
					if (rnd2>=generatorConstants.signalNeighborErrorPercent)
					{
						write("INSERT INTO `Route` (`id`, `Route_entry`, `Route_exit`) VALUES ("+routeid+","+prevSig+","+sig2+");");
					} else
					{
						write("INSERT INTO `Route` (`id`, `Route_entry`, `Route_exit`) VALUES ("+routeid+","+prevSig+",0);");
					}
				} else
				{
					if (rnd2>=generatorConstants.signalNeighborErrorPercent)
					{
						write("INSERT INTO `Route` (`id`, `Route_entry`, `Route_exit`) VALUES ("+routeid+",0,"+sig2+");");
					} else
					{
						write("INSERT INTO `Route` (`id`, `Route_entry`, `Route_exit`) VALUES ("+routeid+",0,0);");
					}
				}
				number++;
				
				int swps = random.nextInt(generatorConstants.MAX_SwPs);
				
				ArrayList<Long> currTracks = new ArrayList<Long>();
				
				for (int j=0; j < swps; j++)
				{
					teid++;
					swpid++;

					long switchid=teid;

					currTracks.add(Long.valueOf(teid));

					int sensors = random.nextInt(generatorConstants.MAX_Sensors);
					
					for (int k=0; k < sensors; k++)
					{
						senid++;
						write("INSERT INTO `Sensor` (`id`) VALUES ("+senid+");");
						number++;
						
						rnd = random.nextInt(100);
						if (rnd>=generatorConstants.switchSensorErrorPercent)
						{
							write("INSERT INTO `Sensor_trackElement` (`Sensor_id` ,`Trackelement_id`)	VALUES ("+senid+", "+switchid+");");
							int rnd3 = random.nextInt(100);
							if (rnd3>=generatorConstants.routeSensorErrorPercent)
							{
								write("INSERT INTO `Route_routeDefinition` (`Route_id` ,`Sensor_id`) VALUES ("+routeid+","+senid+");");
							}
						}
						
						for (int m = 0; m < generatorConstants.MAX_Segments; m++) {

							int value;
							rnd = random.nextInt(100);
							
							if (rnd<generatorConstants.posLengthErrorPercent)
								value = -1 * random.nextInt(1000);
							else
								value = random.nextInt(1000);
							
							teid++;
							write("INSERT INTO `Trackelement` (`id`) VALUES ("+teid+");");
							write("INSERT INTO `Segment` (`Trackelement_id` ,`Segment_length`) VALUES ("+teid+","+value+");");
							number++;
							write("INSERT INTO `Sensor_trackElement` (`Sensor_id` ,`Trackelement_id`)	VALUES ("+senid+", "+teid+");");
							currTracks.add(Long.valueOf(teid));
						}
					}
					
					int state = random.nextInt(4);
					write("INSERT INTO `Trackelement` (`id`) VALUES ("+switchid+");");
					write("INSERT INTO `Switch` (`Trackelement_id` ,`Switch_actualState`) VALUES ("+switchid+","+state+");");
					number++;

					
					rnd = random.nextInt(100);
					if (rnd<generatorConstants.switchSetErrorPercent)
					{
						int wrongstate=3-state;
						write("INSERT INTO `SwitchPosition` (`id` ,`SwitchPosition_route` ,`SwitchPosition_switch` ,`SwitchPosition_switchState`) VALUES ("+swpid+", "+routeid+", "+switchid+", "+wrongstate+");");
					} else
					{
						write("INSERT INTO `SwitchPosition` (`id` ,`SwitchPosition_route` ,`SwitchPosition_switch` ,`SwitchPosition_switchState`) VALUES ("+swpid+", "+routeid+", "+switchid+", "+state+");");
					}
					number++;

					
				}

				long prevte = 0;
				for (Long trackelement : currTracks) {
					if (prevte!=0)
						write("INSERT INTO `Trackelement_connectsTo` (`Trackelement_id` ,`Trackelement_id_connectsTo`) VALUES ("+prevte+","+trackelement+");");
					prevte=trackelement;
				}
				
				if (prevTracks!=null && prevTracks.size()>0 && currTracks.size()>0)
					write("INSERT INTO `Trackelement_connectsTo` (`Trackelement_id` ,`Trackelement_id_connectsTo`) VALUES ("+prevTracks.get(prevTracks.size()-1)+","+currTracks.get(0)+");");
				
				//Loop the last track element of the last route to the first track element of the first route.
				if (i==generatorConstants.MAX_Routes - 1)
				{
					if (currTracks!=null && currTracks.size()>0 && firstTracks.size()>0)
						write("INSERT INTO `Trackelement_connectsTo` (`Trackelement_id` ,`Trackelement_id_connectsTo`) VALUES ("+currTracks.get(currTracks.size()-1)+","+firstTracks.get(0)+");");
				}
				
				
				if (prevTracks==null)
					firstTracks=currTracks;

				prevTracks=currTracks;
				prevSig=sig2;
				//System.out.println("Route"+i+" done.");
			}
			

		}
		write("COMMIT;");
		write("create index Segment_idx_length on Segment (Segment_length);");
		write("create index Route_routeDefinition_idx on Route_routeDefinition (Route_id, Sensor_id);");
		write("create index Sensor_trackElement_idx1 on Sensor_trackElement (Trackelement_id);");
		write("create index Sensor_trackElement_idx2 on Sensor_trackElement (Sensor_id);");
		
		System.out.println(number);

		persistModel();
		System.out.println("Done");
	}

}
