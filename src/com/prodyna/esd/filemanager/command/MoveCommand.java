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

	public MoveCommand(Directory parent, FileSystemElement subject,
			Directory target) {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prodyna.esd.filemanager.command.Command#execute()
	 */
	@Override
	public void execute() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prodyna.esd.filemanager.command.Command#revert()
	 */
	@Override
	public void revert() {
		// TODO Auto-generated method stub

	}

}
