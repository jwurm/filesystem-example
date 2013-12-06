package com.prodyna.esd.filemanager.event;

/**
 * 
 * @author jtrumpfheller
 * 
 */
public class FileAddedEvent extends AbstractFileSystemEvent {

	public FileAddedEvent(Object subject, Object originator) {
		super(subject, originator);
	}
}
