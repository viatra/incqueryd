package distributed.rete.events;

public class VertexTrigger extends Trigger {

	@Override
	public void fire(String message) {
		System.out.println("[VertexTrigger] " + message);
	}

}
