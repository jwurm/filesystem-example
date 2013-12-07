package com.prodyna.esd.filemanager.command;

import java.util.Stack;

public class CommandManager {

	private Stack<Command> commandStack = new Stack<>();

	public void executeCommand(Command command) {
		
		// execute command
		command.execute();
		
		// add to stack
		commandStack.push(command);
	}

	public void undo() {

		// get last command
		Command command = commandStack.pop();
		
		// null safety
		if (command == null){
			return;
		}
		
		// undo
		command.revert();
	}
	
}
