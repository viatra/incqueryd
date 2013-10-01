package graphloader.events;

public class EdgeTrigger extends Trigger {

	@Override
	public void fire(String message) {
		System.out.println("[EdgeTrigger  ] " + message);		
	}	
	
}
