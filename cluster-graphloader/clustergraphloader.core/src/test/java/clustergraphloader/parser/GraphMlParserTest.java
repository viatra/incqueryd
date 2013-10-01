//package clustergraphloader.parser;
//
//import java.util.List;
//
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//import clustergraphloader.graphml.GraphMlParserFirstPass;
//import clustergraphloader.graphml.GraphMlParserSecondPass;
//import clustergraphloader.graphml.XmlSegment;
//
//public class GraphMlParserTest extends TestCase {
//	/**
//	 * Create the test case
//	 * 
//	 * @param testName
//	 *            name of the test case
//	 */
//	public GraphMlParserTest(String testName)
//	{
//		super(testName);
//	}
//
//	/**
//	 * @return the suite of tests being tested
//	 */
//	public static Test suite()
//	{
//		return new TestSuite(GraphMlParserTest.class);
//	}
//
//	public void testFirstPass()
//	{
////		final String fileName = "/home/szarnyasg/data/testBig_User_1.xml";
////		final String fileName = "/home/szarnyasg/data/testBig_User_1.graphml";
////		final String fileName = "/home/szarnyasg/data/my.graphml";
//		final String fileName = "input/graph-of-the-gods.xml";
//		
//		final int dbCount = 1;
//
//		GraphMlParserFirstPass parser1 = new GraphMlParserFirstPass(fileName, dbCount);
//		parser1.parseSegments();
//
//		List<XmlSegment> nodeSegments = parser1.getNodeSegments();
//		List<XmlSegment> edgeSegments = parser1.getEdgeSegments();
//
//		System.out.println(nodeSegments);
//		System.out.println(edgeSegments);
//
//		for (int i = 0; i < nodeSegments.size(); i++) {
//			XmlSegment nodeSegment = nodeSegments.get(i);
//			XmlSegment edgeSegment = edgeSegments.get(i);
//			XmlSegment[] xmlSegments = new XmlSegment[] { nodeSegment, edgeSegment };
//
//			GraphMlParserSecondPass parser2 = new GraphMlParserSecondPass(fileName, xmlSegments);
//			parser2.loadSegments();
//		}
//
//		assertTrue(true);
//	}
//
//}
