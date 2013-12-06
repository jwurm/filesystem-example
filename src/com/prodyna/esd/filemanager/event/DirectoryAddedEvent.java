package com.prodyna.esd.filemanager.event;

/**
 * 
 * @author jtrumpfheller
 * 
 */
public class DirectoryAddedEvent extends AbstractFileSystemEvent {

	public DirectoryAddedEvent(Object subject, Object originator) {
		super(subject, originator);
	}

}
