package hu.bme.mit.incqueryd.tooling.ide.util;

import org.eclipse.ui.console.IConsole;

/**
 * Creates a new console of the given type.
 */
public interface ConsoleFactory<T extends IConsole> {

	T create(String name);

}
