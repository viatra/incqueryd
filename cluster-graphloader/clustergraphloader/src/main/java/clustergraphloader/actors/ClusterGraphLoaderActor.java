package clustergraphloader.actors;

import akka.actor.UntypedActor;

public abstract class ClusterGraphLoaderActor extends UntypedActor {

	public ClusterGraphLoaderActor() {
		super();
		System.out.println(actorString() + " " + this.getClass().getSimpleName() + " constructor called.");
	}

	protected String actorString() {
		return "[" + getSelf().path() + "]";
	}

	@Override
	public void onReceive(Object message) throws Exception {
		System.out.println(actorString() + " onreceive " + message);
	}

	protected void unhandledMessage(Object message) {
		unhandled(message);
		System.out.println(actorString() + " Unhandled message " + message);
	}

}
