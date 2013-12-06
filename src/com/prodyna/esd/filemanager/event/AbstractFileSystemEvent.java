/**
 * 
 */
package com.prodyna.esd.filemanager.event;

/**
 * @author fassmus
 * 
 */
public abstract class AbstractFileSystemEvent implements FileSystemEvent {

	private final Object subject;
	private final Object originator;

	public AbstractFileSystemEvent(Object subject, Object originator) {
		super();
		this.subject = subject;
		this.originator = originator;
	}

	@Override
	public Object getSubject() {
		return subject;
	}

	@Override
	public Object getOriginator() {
		return originator;
	}

}
