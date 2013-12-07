/**
 * 
 */
package com.prodyna.esd.filemanager.event;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;
import com.prodyna.esd.filemanager.model.FileSystemElement;

/**
 * @author fassmus
 * 
 */
public class EventBuilder {
	public static FileSystemEvent build(FileSystemElement source,
			Directory originator, EventType eventType) {
		FileSystemEvent event;
		if (source instanceof Directory) {
			Directory sourceDir = (Directory) source;
			event = createDirectoryEvent(sourceDir, originator, eventType);
		} else if (source instanceof File) {
			File sourceFile = (File) source;
			event = createFileEvent(sourceFile, originator, eventType);
		} else {
			throw new IllegalArgumentException("Unkown event source!");
		}
		return event;
	}

	private static FileSystemEvent createDirectoryEvent(Directory source,
			Directory originator, EventType eventType) {
		FileSystemEvent event;

		switch (eventType) {
		case ADDED:
			event = new DirectoryAddedEvent(source, originator);
			break;
		case REMOVED:
		default:
			event = new DirectoryRemovedEvent(source, originator);
		}

		return event;
	}

	private static FileSystemEvent createFileEvent(File source,
			Directory originator, EventType eventType) {
		FileSystemEvent event;

		switch (eventType) {
		case ADDED:
			event = new FileAddedEvent(source, originator);
			break;
		case REMOVED:
		default:
			event = new FileRemovedEvent(source, originator);
		}

		return event;
	}
}
