package com.prodyna.esd.filemanager.event;

/**
 * 
 * @author jtrumpfheller
 * 
 */
public class FileRemovedEvent extends AbstractFileSystemEvent {

	public FileRemovedEvent(Object subject, Object originator) {
		super(subject, originator);
	}
}
