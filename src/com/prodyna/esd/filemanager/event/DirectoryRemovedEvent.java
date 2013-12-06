package com.prodyna.esd.filemanager.event;

/**
 * 
 * @author jtrumpfheller
 * 
 */
public class DirectoryRemovedEvent extends AbstractFileSystemEvent {

	public DirectoryRemovedEvent(Object subject, Object originator) {
		super(subject, originator);
	}

}
