package hu.bme.mit.incqueryd.tooling.ide.util;

import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class IqdConsole extends MessageConsole {

	private final MessageConsoleStream stream = newMessageStream();

	public IqdConsole(String name) {
		super(name, null);
	}

	public MessageConsoleStream getStream() {
		return stream;
	}

	private static final ConsoleFactory<IqdConsole> FACTORY = new ConsoleFactory<IqdConsole>() {

		@Override
		public IqdConsole create(String name) {
			return new IqdConsole(name);
		}

	};

	public static IqdConsole getInstance() {
		IqdConsole console = ConsoleUtils.getConsole("IncQuery-D", FACTORY);
		ConsoleUtils.showConsole(console);
		return console;
	}

}
