/**
 * 
 */
package com.prodyna.esd.filemanager.command;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.FileSystemElement;

/**
 * @author fassmus
 * 
 */
public class MoveCommand implements Command {

	private Directory parent;
	private FileSystemElement subject;
	private Directory target;

	public MoveCommand(Directory parent, FileSystemElement subject,
			Directory target) {
		this.parent = parent;
		this.subject = subject;
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prodyna.esd.filemanager.command.Command#execute()
	 */
	@Override
	public void execute() {
		parent.remove(subject);
		target.add(subject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prodyna.esd.filemanager.command.Command#revert()
	 */
	@Override
	public void revert() {
		target.remove(subject);
		parent.add(subject);
	}

}
