/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager.observer;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.FileSystemManager;
import com.prodyna.esd.filemanager.MyFileSystemManager;
import com.prodyna.esd.filemanager.event.DirectoryAddedEvent;
import com.prodyna.esd.filemanager.event.DirectoryRemovedEvent;
import com.prodyna.esd.filemanager.event.FileAddedEvent;
import com.prodyna.esd.filemanager.event.FileRemovedEvent;
import com.prodyna.esd.filemanager.event.FileSystemEvent;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.ImageType;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding;

/**
 * Unit tests that test the observer part of the filemanager.
 * 
 * @author Oliver Schimmel
 */
public class FileManagerObserverTest {

	private static final int NUMBER_OF_EVENTS = 6;
	private FileSystemManager manager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		manager = new MyFileSystemManager();
	}

	/**
	 * Test method for {@link com.prodyna.esd.filemanager.observer.ObserverHelper#addListener(com.prodyna.esd.filemanager.observer.FileSystemListener)}.
	 */
	@Test
	public void testAddListener() {
		manager.addListener(new FileSystemListener() {
			@Override
			public void eventCallback(FileSystemEvent event) {
			}
		});
		manager.addListener(new FileSystemListener() {
			@Override
			public void eventCallback(FileSystemEvent event) {
			}
		});
	}

	/**
	 * Test method for {@link com.prodyna.esd.filemanager.observer.ObserverHelper#removeListener(com.prodyna.esd.filemanager.observer.FileSystemListener)}.
	 */
	@Test
	public void testRemoveListener() {
		FileSystemListener listener = new FileSystemListener() {
			@Override
			public void eventCallback(FileSystemEvent event) {
			}
		};
		manager.addListener(listener);
		manager.removeListener(listener);
	}

	/**
	 * Test method for {@link com.prodyna.esd.filemanager.observer.ObserverHelper#notifyListeners(com.prodyna.esd.filemanager.event.FileSystemEvent)}.
	 */
	@Test
	public void testNotifyListeners() {
		final List<FileSystemEvent> eventsOccurred = new LinkedList<FileSystemEvent>();
		FileSystemListener listener = new FileSystemListener() {
			@Override
			public void eventCallback(FileSystemEvent event) {
				eventsOccurred.add(event);
			}
		};
		manager.addListener(listener);
		
		// Adding directory
		Directory directory = manager.addDirectory("Testdir", manager.getRoot());

		// Adding files
		TextDocument textDocument = manager.addTextFile("text", manager.getRoot(), 1000, TextEncoding.UTF8, 10);
		ImageFile imageFile = manager.addImageFile("image", directory, 1000, ImageType.GIF, 640, 480);
		
		// Removing files
		manager.removeFileSystemElement(textDocument);
		manager.removeFileSystemElement(imageFile);

		// Removing directory
		manager.removeFileSystemElement(directory);
		
		
		// Deregister
		manager.removeListener(listener);
		
		// Check the events.
		Assert.assertEquals(NUMBER_OF_EVENTS + " events should have occurred", NUMBER_OF_EVENTS, eventsOccurred.size());
		
		Assert.assertEquals(directory, eventsOccurred.get(0).getSubject());
		Assert.assertEquals(manager.getRoot(), eventsOccurred.get(0).getOriginator());
		Assert.assertTrue(eventsOccurred.get(0) instanceof DirectoryAddedEvent);

		Assert.assertEquals(textDocument, eventsOccurred.get(1).getSubject());
		Assert.assertEquals(manager.getRoot(), eventsOccurred.get(1).getOriginator());
		Assert.assertTrue(eventsOccurred.get(1) instanceof FileAddedEvent);

		Assert.assertEquals(imageFile, eventsOccurred.get(2).getSubject());
		Assert.assertEquals(directory, eventsOccurred.get(2).getOriginator());
		Assert.assertTrue(eventsOccurred.get(2) instanceof FileAddedEvent);

		Assert.assertEquals(textDocument, eventsOccurred.get(3).getSubject());
		Assert.assertEquals(manager.getRoot(), eventsOccurred.get(3).getOriginator());
		Assert.assertTrue(eventsOccurred.get(3) instanceof FileRemovedEvent);

		Assert.assertEquals(imageFile, eventsOccurred.get(4).getSubject());
		Assert.assertEquals(directory, eventsOccurred.get(4).getOriginator());
		Assert.assertTrue(eventsOccurred.get(4) instanceof FileRemovedEvent);

		Assert.assertEquals(directory, eventsOccurred.get(5).getSubject());
		Assert.assertEquals(manager.getRoot(), eventsOccurred.get(5).getOriginator());
		Assert.assertTrue(eventsOccurred.get(5) instanceof DirectoryRemovedEvent);
		
	}

}
