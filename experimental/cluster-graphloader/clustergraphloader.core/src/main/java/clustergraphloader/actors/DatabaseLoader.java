package clustergraphloader.actors;

import akka.actor.ActorRef;
import clustergraphloader.graphml.GraphMlParserSecondPass;
import clustergraphloader.graphml.XmlSegment;
import clustergraphloader.messages.ActorMessage;
import clustergraphloader.messages.LoadMessage;

public class DatabaseLoader extends ClusterGraphLoaderActor {

	public DatabaseLoader() {
		super();
		
	}
	
	@Override
	public void onReceive(Object message) throws Exception {
		super.onReceive(message);

		if (message instanceof LoadMessage) {
			LoadMessage loadMessage = (LoadMessage) message;
			load(getSender(), loadMessage);			
		}

		else {
			unhandledMessage(message);
		}
		
	}

	/**
	 * Parses the XML segments in the file.
	 * 
	 * @param xmlSegment
	 * @param graphMlFile
	 * @param fileName
	 */
	private void load(ActorRef coordinator, LoadMessage loadMessage) {
		String fileName = loadMessage.getFileName();
		XmlSegment[] xmlSegments = loadMessage.getXmlSegments();
				
		GraphMlParserSecondPass graphMlParser2 = new GraphMlParserSecondPass(fileName, xmlSegments);
		graphMlParser2.loadSegments();
		graphMlParser2.close();
		
		coordinator.tell(ActorMessage.READY, getSelf());		
	}

}
