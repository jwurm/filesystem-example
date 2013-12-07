package com.prodyna.esd.filemanager.command;

import java.util.Stack;

public class CommandManager {

	private Stack<Command> commandStack = new Stack<>();

	public void executeCommand(Command command) {
		command.execute();
		commandStack.push(command);

	}

	public void undo() {
		Command undoCommand = commandStack.pop();
		if (undoCommand != null) {
			undoCommand.revert();
		}
	}
}
