package com.prodyna.esd.filemanager.command;

public interface Command {
	public void execute();

	public void revert();
}
