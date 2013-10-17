package hu.bme.mit.train.generator;

import hu.bme.mit.train.common.RuntimeConstants;

import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class GeneratorConfig {
	public String variant;
	public String syntax;
	public boolean genUUID;
	public long RANDOM;
	public int MAX_IndividualContainer;
	public int Size;
	public int MAX_Segments;
	public int MAX_Routes;
	public int MAX_SwPs;
	public int MAX_Sensors;
	public int posLengthErrorPercent;
	public int switchSensorErrorPercent;
	public int routeSensorErrorPercent;
	public int signalNeighborErrorPercent;
	public int switchSetErrorPercent;
	public ArrayList<Integer> sizes;
	public String instanceModelPath;
	public String pathProject_InstanceModels;
	public String pathWorkspace;
	private int metamodel;
	private GraphFormat graphFormat;

	public GeneratorConfig() {
		genUUID = false;
		RANDOM = 19871053l;
		MAX_IndividualContainer = 1;
		Size = 1;
		instanceModelPath = null;
	}

	public void processParameters(String[] args) throws Exception {
		Options options = new Options();
		options.addOption("scenario", true, "User or XForm");
		options.addOption("syntax", true, "EMF/RDF/SQL/Neo4j");
		options.addOption("UUID", false, "generate UUID, if this option is present");
		options.addOption("metamodel", true, "0-default; 1-do not generate metamodel for RDF TBox");
		options.addOption("graphFormat", true, "graph output format");
		options.addOption("sizes", true, "test sizes, e.g. 1-8 or 1,8-512");
		options.addOption("instanceModelPath", true, "directory path where the models will be generated");
		options.addOption("pathProject_InstanceModels", true, "path of the hu.bme.mit.Train.InstanceModels project");
		options.addOption("pathWorkspace", true, "path of the Eclipse workspace with all projects");

		CommandLineParser parser = new PosixParser();
		CommandLine cmd;

		try {
			cmd = parser.parse(options, args);

			if (cmd.getOptionValue("scenario") != null) {
				variant = "_" + cmd.getOptionValue("scenario") + "_";
				if ("_User_".equals(variant)) {
					// set Size before call
					MAX_Segments = 5;
					MAX_Routes = 20 * Size;
					MAX_SwPs = 20;
					MAX_Sensors = 10;
					posLengthErrorPercent = 2;
					switchSensorErrorPercent = 2;
					routeSensorErrorPercent = 2;
					signalNeighborErrorPercent = 7;
					switchSetErrorPercent = 2;
				} else if ("_XForm_".equals(variant)) {
					// set Size before call
					MAX_Segments = 5;
					MAX_Routes = 20 * Size;
					MAX_SwPs = 20;
					MAX_Sensors = 10;
					posLengthErrorPercent = 10;
					switchSensorErrorPercent = 4;
					routeSensorErrorPercent = 10;
					signalNeighborErrorPercent = 8;
					switchSetErrorPercent = 10;
				}
			}
			if (cmd.getOptionValue("syntax") != null) {
				syntax = cmd.getOptionValue("syntax");
			}
			if (cmd.hasOption("UUID")) {
				genUUID = true;
			}
			if (cmd.getOptionValue("metamodel") != null) {
				metamodel = new Integer(cmd.getOptionValue("metamodel"));
			} else {
				metamodel = 0;
			}

			if (cmd.getOptionValue("pathWorkspace") != null) {
				pathWorkspace = cmd.getOptionValue("pathWorkspace");
			} else {
				pathWorkspace = RuntimeConstants.workspacePath;
			}
			if (cmd.getOptionValue("pathProject_InstanceModels") != null) {
				pathProject_InstanceModels = cmd.getOptionValue("pathProject_InstanceModels");
			} else {
				pathProject_InstanceModels = pathWorkspace + "/hu.bme.mit.Train.InstanceModels";
			}
			if (cmd.getOptionValue("instanceModelPath") != null) {
				instanceModelPath = cmd.getOptionValue("instanceModelPath");
			} else {
				instanceModelPath = pathProject_InstanceModels + "/models";
			}
		
			if (getSyntax().equals("Neo4j")) {
				String graphFormatString = cmd.getOptionValue("graphFormat");
				if (graphFormatString != null) {
					switch (graphFormatString) {
					case "GraphML":
						graphFormat = GraphFormat.GRAPHML;
						break;
					case "BlueprintsGraphSON":
						graphFormat = GraphFormat.BLUEPRINTS_GRAPHSON;
						break;
					case "FaunusGraphSON":
						graphFormat = GraphFormat.FAUNUS_GRAPHSON;
						break;
					default:
						throw new Exception("Invalid GraphFormat specified.");
					}
				} else {
					throw new Exception("GraphFormat not specified.");
				}
			}
			
			sizes = null;
			if (cmd.getOptionValue("sizes") != null) {
				sizes = new ArrayList<Integer>();
				String sizesStr = cmd.getOptionValue("sizes");
				String[] sizeRanges = sizesStr.split(",");
				for (String sizeRange : sizeRanges) {
					Integer from = new Integer(sizeRange.split("-")[0]);
					Integer to;
					try {
						to = new Integer(sizeRange.split("-")[1]);
					} catch (ArrayIndexOutOfBoundsException e) {
						to = from; // only number without dash
					}
					if (from != 0) {
						for (int i = from; i <= to; i *= 2) {
							sizes.add(i);
						}
					}
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getSyntax() {
		return syntax;
	}

	public void setSyntax(String syntax) {
		this.syntax = syntax;
	}

	public boolean isGenUUID() {
		return genUUID;
	}

	public void setGenUUID(boolean genUUID) {
		this.genUUID = genUUID;
	}

	public long getRandom() {
		return RANDOM;
	}

	public void setRandom(long random) {
		RANDOM = random;
	}

	public int getMAX_IndividualContainer() {
		return MAX_IndividualContainer;
	}

	public void setMAX_IndividualContainer(int mAX_IndividualContainer) {
		MAX_IndividualContainer = mAX_IndividualContainer;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	public int getMAX_Segments() {
		return MAX_Segments;
	}

	public void setMAX_Segments(int mAX_Segments) {
		MAX_Segments = mAX_Segments;
	}

	public int getMAX_Routes() {
		return MAX_Routes;
	}

	public void setMAX_Routes(int mAX_Routes) {
		MAX_Routes = mAX_Routes;
	}

	public int getMAX_SwPs() {
		return MAX_SwPs;
	}

	public void setMAX_SwPs(int mAX_SwPs) {
		MAX_SwPs = mAX_SwPs;
	}

	public int getMAX_Sensors() {
		return MAX_Sensors;
	}

	public void setMAX_Sensors(int mAX_Sensors) {
		MAX_Sensors = mAX_Sensors;
	}

	public int getPosLengthErrorPercent() {
		return posLengthErrorPercent;
	}

	public void setPosLengthErrorPercent(int posLengthErrorPercent) {
		this.posLengthErrorPercent = posLengthErrorPercent;
	}

	public int getSwitchSensorErrorPercent() {
		return switchSensorErrorPercent;
	}

	public void setSwitchSensorErrorPercent(int switchSensorErrorPercent) {
		this.switchSensorErrorPercent = switchSensorErrorPercent;
	}

	public int getRouteSensorErrorPercent() {
		return routeSensorErrorPercent;
	}

	public void setRouteSensorErrorPercent(int routeSensorErrorPercent) {
		this.routeSensorErrorPercent = routeSensorErrorPercent;
	}

	public int getSignalNeighborErrorPercent() {
		return signalNeighborErrorPercent;
	}

	public void setSignalNeighborErrorPercent(int signalNeighborErrorPercent) {
		this.signalNeighborErrorPercent = signalNeighborErrorPercent;
	}

	public int getSwitchSetErrorPercent() {
		return switchSetErrorPercent;
	}

	public void setSwitchSetErrorPercent(int switchSetErrorPercent) {
		this.switchSetErrorPercent = switchSetErrorPercent;
	}

	public ArrayList<Integer> getSizes() {
		return sizes;
	}

	public void setSizes(ArrayList<Integer> sizes) {
		this.sizes = sizes;
	}

	public String getPathProject_InstanceModels() {
		return pathProject_InstanceModels;
	}

	public void setPathProject_InstanceModels(String pathProject_InstanceModels) {
		this.pathProject_InstanceModels = pathProject_InstanceModels;
	}

	public String getPathWorkspace() {
		return pathWorkspace;
	}

	public void setPathWorkspace(String pathWorkspace) {
		this.pathWorkspace = pathWorkspace;
	}

	public int getMetamodel() {
		return metamodel;
	}

	public void setMetamodel(int metamodel) {
		this.metamodel = metamodel;
	}

	public GraphFormat getGraphFormat() {
		return graphFormat;
	}

}
