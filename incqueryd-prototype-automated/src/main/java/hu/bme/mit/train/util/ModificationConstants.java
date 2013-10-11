package hu.bme.mit.train.util;

import java.util.HashMap;
import java.util.Map;

public class ModificationConstants {
		
		// MAIN random constant
		public static final long RANDOM = 19871053l;

		// model size
		public static final Map<Integer, Integer> modelSize_UserScenario = new HashMap<Integer, Integer>();
		static {
			modelSize_UserScenario.put(1, 5537);
			modelSize_UserScenario.put(2, 10855);
			modelSize_UserScenario.put(4, 22499);
			modelSize_UserScenario.put(8, 46047);
			modelSize_UserScenario.put(16, 89315);
			modelSize_UserScenario.put(32, 179779);
			modelSize_UserScenario.put(64, 357579);
			modelSize_UserScenario.put(128, 713709);
			modelSize_UserScenario.put(256, 1418335);
			modelSize_UserScenario.put(512, 2853955);
		}
		public static final Map<Integer, Integer> modelSize_ModelXFormScenario = new HashMap<Integer, Integer>();
		static {
			modelSize_ModelXFormScenario.put(1, 5537);
			modelSize_ModelXFormScenario.put(2, 10855);
			modelSize_ModelXFormScenario.put(4, 22499);
			modelSize_ModelXFormScenario.put(8, 46047);
			modelSize_ModelXFormScenario.put(16, 89315);
			modelSize_ModelXFormScenario.put(32, 179779);
			modelSize_ModelXFormScenario.put(64, 357579);
			modelSize_ModelXFormScenario.put(128, 713709);
			modelSize_ModelXFormScenario.put(256, 1418335);
			modelSize_ModelXFormScenario.put(512, 2853955);
		}
		public static Integer modelSizeGet(String scenario, Integer size) {
			if ("UserScenario".equals(scenario)) {
				return modelSize_UserScenario.get(size);
			} else if ("ModelXFormScenario".equals(scenario)) {
				return modelSize_ModelXFormScenario.get(size);
			}
			return null;
		}

		// number of Segments
		public static final Map<Integer, Integer> modelSize_UserScenario_Segment = new HashMap<Integer, Integer>();
		static {
			modelSize_UserScenario_Segment.put(1, 4245);
			modelSize_UserScenario_Segment.put(2, 8325);
			modelSize_UserScenario_Segment.put(4, 17300);
			modelSize_UserScenario_Segment.put(8, 35470);
			modelSize_UserScenario_Segment.put(16, 68705);
			modelSize_UserScenario_Segment.put(32, 138310);
			modelSize_UserScenario_Segment.put(64, 275250);
			modelSize_UserScenario_Segment.put(128, 549485);
			modelSize_UserScenario_Segment.put(256, 1091915);
			modelSize_UserScenario_Segment.put(512, 2000000);
		}
		public static final Map<Integer, Integer> modelSize_ModelXFormScenario_Segment = new HashMap<Integer, Integer>();
		static {
			modelSize_ModelXFormScenario_Segment.put(1, 4245);
			modelSize_ModelXFormScenario_Segment.put(2, 8325);
			modelSize_ModelXFormScenario_Segment.put(4, 17300);
			modelSize_ModelXFormScenario_Segment.put(8, 35470);
			modelSize_ModelXFormScenario_Segment.put(16, 68705);
			modelSize_ModelXFormScenario_Segment.put(32, 138310);
			modelSize_ModelXFormScenario_Segment.put(64, 275250);
			modelSize_ModelXFormScenario_Segment.put(128, 549485);
			modelSize_ModelXFormScenario_Segment.put(256, 1091915);
			modelSize_ModelXFormScenario_Segment.put(512, 2000000);
		}

		// number of Sensors
		public static final Map<Integer, Integer> modelSize_UserScenario_Sensor = new HashMap<Integer, Integer>();
		static {
			modelSize_UserScenario_Sensor.put(1, 849);
			modelSize_UserScenario_Sensor.put(2, 1665);
			modelSize_UserScenario_Sensor.put(4, 3460);
			modelSize_UserScenario_Sensor.put(8, 7094);
			modelSize_UserScenario_Sensor.put(16, 13741);
			modelSize_UserScenario_Sensor.put(32, 27662);
			modelSize_UserScenario_Sensor.put(64, 55050);
			modelSize_UserScenario_Sensor.put(128, 109897);
			modelSize_UserScenario_Sensor.put(256, 218383);
			modelSize_UserScenario_Sensor.put(512, 400000);
		}
		public static final Map<Integer, Integer> modelSize_ModelXFormScenario_Sensor = new HashMap<Integer, Integer>();
		static {
			modelSize_ModelXFormScenario_Sensor.put(1, 849);
			modelSize_ModelXFormScenario_Sensor.put(2, 1665);
			modelSize_ModelXFormScenario_Sensor.put(4, 3460);
			modelSize_ModelXFormScenario_Sensor.put(8, 7094);
			modelSize_ModelXFormScenario_Sensor.put(16, 13741);
			modelSize_ModelXFormScenario_Sensor.put(32, 27662);
			modelSize_ModelXFormScenario_Sensor.put(64, 55050);
			modelSize_ModelXFormScenario_Sensor.put(128, 109897);
			modelSize_ModelXFormScenario_Sensor.put(256, 218383);
			modelSize_ModelXFormScenario_Sensor.put(512, 400000);
		}

		// number of Switches
		public static final Map<Integer, Integer> modelSize_UserScenario_Switch = new HashMap<Integer, Integer>();
		static {
			modelSize_UserScenario_Switch.put(1, 201);
			modelSize_UserScenario_Switch.put(2, 392);
			modelSize_UserScenario_Switch.put(4, 789);
			modelSize_UserScenario_Switch.put(8, 1581);
			modelSize_UserScenario_Switch.put(16, 3114);
			modelSize_UserScenario_Switch.put(32, 6263);
			modelSize_UserScenario_Switch.put(64, 12359);
			modelSize_UserScenario_Switch.put(128, 24603);
			modelSize_UserScenario_Switch.put(256, 48898);
			modelSize_UserScenario_Switch.put(512, 96000);
		}
		public static final Map<Integer, Integer> modelSize_ModelXFormScenario_Switch = new HashMap<Integer, Integer>();
		static {
			modelSize_ModelXFormScenario_Switch.put(1, 201);
			modelSize_ModelXFormScenario_Switch.put(2, 392);
			modelSize_ModelXFormScenario_Switch.put(4, 789);
			modelSize_ModelXFormScenario_Switch.put(8, 1581);
			modelSize_ModelXFormScenario_Switch.put(16, 3114);
			modelSize_ModelXFormScenario_Switch.put(32, 6263);
			modelSize_ModelXFormScenario_Switch.put(64, 12359);
			modelSize_ModelXFormScenario_Switch.put(128, 24603);
			modelSize_ModelXFormScenario_Switch.put(256, 48898);
			modelSize_ModelXFormScenario_Switch.put(512, 96000);
		}

		// number of Routes
		public static final Map<Integer, Integer> modelSize_UserScenario_Route = new HashMap<Integer, Integer>();
		static {
			modelSize_UserScenario_Route.put(1, 20);
			modelSize_UserScenario_Route.put(2, 40);
			modelSize_UserScenario_Route.put(4, 80);
			modelSize_UserScenario_Route.put(8, 160);
			modelSize_UserScenario_Route.put(16, 320);
			modelSize_UserScenario_Route.put(32, 640);
			modelSize_UserScenario_Route.put(64, 1280);
			modelSize_UserScenario_Route.put(128, 2560);
			modelSize_UserScenario_Route.put(256, 5120);
			modelSize_UserScenario_Route.put(512, 10000);
		}
		public static final Map<Integer, Integer> modelSize_ModelXFormScenario_Route = new HashMap<Integer, Integer>();
		static {
			modelSize_ModelXFormScenario_Route.put(1, 20);
			modelSize_ModelXFormScenario_Route.put(2, 40);
			modelSize_ModelXFormScenario_Route.put(4, 80);
			modelSize_ModelXFormScenario_Route.put(8, 160);
			modelSize_ModelXFormScenario_Route.put(16, 320);
			modelSize_ModelXFormScenario_Route.put(32, 640);
			modelSize_ModelXFormScenario_Route.put(64, 1280);
			modelSize_ModelXFormScenario_Route.put(128, 2560);
			modelSize_ModelXFormScenario_Route.put(256, 5120);
			modelSize_ModelXFormScenario_Route.put(512, 10000);
		}
		
		public static Integer getNumberOfPossiblyBadElements(String scenario, String testCase, Integer size) {
			if ("UserScenario".equals(scenario)) {
				if ("TestCasePosLength".equals(testCase))
					return modelSize_UserScenario_Segment.get(size);
				else if ("TestCaseRouteSensor".equals(testCase))
					return modelSize_UserScenario_Sensor.get(size);
				else if ("TestCaseSwitchSensor".equals(testCase))
					return modelSize_UserScenario_Switch.get(size);
				else if ("TestCaseSignalNeighbor".equals(testCase))
					return modelSize_UserScenario_Route.get(size);
			} else if ("ModelXFormScenario".equals(scenario)) {
				if ("TestCasePosLength".equals(testCase))
					return modelSize_ModelXFormScenario_Segment.get(size);
				else if ("TestCaseRouteSensor".equals(testCase))
					return modelSize_ModelXFormScenario_Sensor.get(size);
				else if ("TestCaseSwitchSensor".equals(testCase))
					return modelSize_ModelXFormScenario_Switch.get(size);
				else if ("TestCaseSignalNeighbor".equals(testCase))
					return modelSize_ModelXFormScenario_Route.get(size);
			}
			return null;
		}
		
}
