/**
 * ESD Design patterns example.
 * Copyright (c) 2013 by PRODYNA AG.
 */
package com.prodyna.esd.filemanager;

import static org.junit.Assert.fail;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.event.FileSystemEvent;
import com.prodyna.esd.filemanager.model.ArchiveFile;
import com.prodyna.esd.filemanager.model.CompressionType;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.ImageType;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding;
import com.prodyna.esd.filemanager.observer.FileSystemListener;
import com.prodyna.esd.filemanager.visitor.samples.DemoVisitor;
import com.prodyna.esd.filesystem.filemanager.search.NameSearchCriteria;
import com.prodyna.esd.filesystem.filemanager.search.PageRangeCriteria;
import com.prodyna.esd.filesystem.filemanager.search.SearchCriteria;
import com.prodyna.esd.filesystem.filemanager.search.SearchCriteriaBuilder;

/**
 * Unit tests to prove {@link MyFileSystemManager} functions working correctly.
 * 
 * @author Oliver Schimmel
 */
public class MyFileSystemManagerTest {

	private static final long NUMBER_OF_PAGES = 10;
	/**
	 * Instance of the test file system manager.
	 */
	private MyFileSystemManager fileSystemManager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fileSystemManager = MyFileSystemManager.getInstance();
	    fileSystemManager.getRoot().getElements().clear();
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#addListener(com.prodyna.esd.filemanager.FileSystemListener)}
	 * .
	 */
	@Test
	public void testAddListener() {
		final Set<FileSystemEvent> events = new LinkedHashSet<FileSystemEvent>();
		fileSystemManager.addListener(new FileSystemListener() {

			@Override
			public void eventCallback(FileSystemEvent event) {
				events.add(event);
			}
		});

		Assert.assertEquals(0, events.size());
		fileSystemManager.addTextFile("test1", fileSystemManager.getRoot(),
				1000, TextEncoding.PDF, 10);
		Assert.assertEquals(1, events.size());
		fileSystemManager.addTextFile("test2", fileSystemManager.getRoot(),
				1000, TextEncoding.PDF, 10);
		Assert.assertEquals(2, events.size());
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#removeListener(com.prodyna.esd.filemanager.FileSystemListener)}
	 * .
	 */
	@Test
	public void testRemoveListener() {
		final Set<FileSystemEvent> events = new LinkedHashSet<FileSystemEvent>();
		FileSystemListener listener = new FileSystemListener() {
			@Override
			public void eventCallback(FileSystemEvent event) {
				events.add(event);
			}
		};
		fileSystemManager.addListener(listener);

		Assert.assertEquals(0, events.size());
		fileSystemManager.addTextFile("test1", fileSystemManager.getRoot(),
				1000, TextEncoding.PDF, 10);
		Assert.assertEquals(1, events.size());
		fileSystemManager.removeListener(listener);
		fileSystemManager.addTextFile("test2", fileSystemManager.getRoot(),
				1000, TextEncoding.PDF, 10);
		Assert.assertEquals(1, events.size());
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#getRoot()}.
	 */
	@Test
	public void testGetRoot() {
		Directory root = fileSystemManager.getRoot();
		Directory root2 = fileSystemManager.getRoot();
		Assert.assertNotNull(root);
		Assert.assertSame(root, root2);
		Assert.assertEquals("/", root.getName());
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#addDirectory(java.lang.String, com.prodyna.esd.filemanager.model.Directory)}
	 * .
	 */
	@Test
	public void testAddDirectory() {
		Directory root = fileSystemManager.getRoot();

		Directory directory = fileSystemManager.addDirectory("test", root);
		Assert.assertEquals("test", directory.getName());
		Assert.assertEquals("/", directory.getParentDirectory().getName());
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#demo()} .
	 */
	@Test
	public void testDirectoryDemoVisitor() {
		Directory root = fileSystemManager.getRoot();

		Directory directory = fileSystemManager.addDirectory("directory 1",
				root);
		Directory directory2 = fileSystemManager.addDirectory("directory 2",
				root);
		fileSystemManager.addTextFile("text", directory, 1000,
				TextEncoding.UTF8, NUMBER_OF_PAGES);
		fileSystemManager.addImageFile("image", directory2, 1000,
				ImageType.GIF, 640, 480);

		DemoVisitor demoVisitor = new DemoVisitor();
		root.accept(demoVisitor);
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#addDirectory(java.lang.String, com.prodyna.esd.filemanager.model.Directory)}
	 * .
	 */
	@Test
	public void testDirectoryListVisitor() {
		Directory root = fileSystemManager.getRoot();

		Directory directory = fileSystemManager.addDirectory("directory 1",
				root);
		Directory directory2 = fileSystemManager.addDirectory("directory 2",
				root);
		fileSystemManager.addTextFile("text", directory, 1000,
				TextEncoding.UTF8, NUMBER_OF_PAGES);
		fileSystemManager.addImageFile("image", directory2, 1000,
				ImageType.GIF, 640, 480);

		fileSystemManager.list();
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#addTextFile(java.lang.String, com.prodyna.esd.filemanager.model.Directory, long, java.lang.String, com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding)}
	 * .
	 */
	@Test
	public void testAddTextFile() {
		Directory root = fileSystemManager.getRoot();

		TextDocument textDocument = fileSystemManager.addTextFile("text", root,
				1000, TextEncoding.UTF8, NUMBER_OF_PAGES);
		Assert.assertEquals("text", textDocument.getName());
		Assert.assertEquals("/", textDocument.getParentDirectory().getName());
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#addArchiveFile(java.lang.String, com.prodyna.esd.filemanager.model.Directory, long, java.lang.String, com.prodyna.esd.filemanager.model.CompressionType, long)}
	 * .
	 */
	@Test
	public void testAddArchiveFile() {
		Directory root = fileSystemManager.getRoot();

		ArchiveFile archiveFile = fileSystemManager.addArchiveFile("archive",
				root, 1000, CompressionType.JAR, 2000);
		Assert.assertEquals("archive", archiveFile.getName());
		Assert.assertEquals("/", archiveFile.getParentDirectory().getName());
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#addImageFile(java.lang.String, com.prodyna.esd.filemanager.model.Directory, long, java.lang.String, com.prodyna.esd.filemanager.model.ImageType, int, int)}
	 * .
	 */
	@Test
	public void testAddImageFile() {
		Directory root = fileSystemManager.getRoot();

		ImageFile imageFile = fileSystemManager.addImageFile("image", root,
				1000, ImageType.GIF, 640, 480);
		Assert.assertEquals("image", imageFile.getName());
		Assert.assertEquals("/", imageFile.getParentDirectory().getName());
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#removeFileSystemElement(com.prodyna.esd.filemanager.model.FileSystemElement)}
	 * .
	 */
	@Test
	public void testRemoveFileSystemElement() {
		Directory root = fileSystemManager.getRoot();
		TextDocument textDocument = fileSystemManager.addTextFile("text", root,
				1000, TextEncoding.UTF8, NUMBER_OF_PAGES);

		Assert.assertEquals(1, fileSystemManager.getRoot().getElements().size());

		fileSystemManager.removeFileSystemElement(textDocument);
		Assert.assertEquals(0, fileSystemManager.getRoot().getElements().size());
	}

    /**
     * Test method for
     * {@link com.prodyna.esd.filemanager.MyFileSystemManager#move(com.prodyna.esd.filemanager.model.FileSystemElement, com.prodyna.esd.filemanager.model.Directory)}
     * .
     */
    @Test
    public void testMove() {
        //create directory structure
        Directory dirWindows = fileSystemManager.addDirectory("windows", fileSystemManager.getRoot());
        Directory dirWindowsSystem32 = fileSystemManager.addDirectory("system32", dirWindows);
        Directory dirWindowsSystem32Drivers = fileSystemManager.addDirectory("drivers", dirWindowsSystem32);
        Directory dirReadTheseArticles = fileSystemManager.addDirectory("readTheseArticles", fileSystemManager.getRoot());
        Directory dirBackup = fileSystemManager.addDirectory("backup", fileSystemManager.getRoot());
        
        fileSystemManager.addTextFile("readme.pdf", dirWindows, 1000, TextEncoding.PDF, 5);
        fileSystemManager.addTextFile("readregistry.dll", dirWindowsSystem32, 1000, TextEncoding.UTF8, 5);
        fileSystemManager.addTextFile("svchost.dll", dirWindowsSystem32, 1000, TextEncoding.UTF8, 5);
        fileSystemManager.addTextFile("system32.dll", dirWindowsSystem32, 1000, TextEncoding.UTF8, 5);
        fileSystemManager.addTextFile("direct3d.dll", dirWindowsSystem32Drivers, 1000, TextEncoding.UTF8, 5);
        fileSystemManager.addTextFile("Effects of prolonged aspirin use", dirReadTheseArticles, 1000, TextEncoding.PDF, 5);
        
        Assert.assertEquals(3, fileSystemManager.getRoot().getElements().size());
        Assert.assertEquals(2, dirWindows.getElements().size());
        Assert.assertEquals(4, dirWindowsSystem32.getElements().size());
        Assert.assertEquals(1, dirWindowsSystem32Drivers.getElements().size());
        Assert.assertEquals(1, dirReadTheseArticles.getElements().size());
        Assert.assertEquals(0, dirBackup.getElements().size());
        fileSystemManager.move(new SearchCriteriaBuilder<FileSystemElement>().set(new NameSearchCriteria<FileSystemElement>("read.*")).getSearchCriteria(), dirBackup);
        
        Assert.assertEquals(2, fileSystemManager.getRoot().getElements().size());
        Assert.assertEquals(1, dirWindows.getElements().size());
        Assert.assertEquals(3, dirWindowsSystem32.getElements().size());
        Assert.assertEquals(1, dirWindowsSystem32Drivers.getElements().size());
        Assert.assertEquals(1, dirReadTheseArticles.getElements().size());
        Assert.assertEquals(3, dirBackup.getElements().size());
        
        
    }

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#find(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindString() {

	    
		Directory root = fileSystemManager.getRoot();

		@SuppressWarnings("unused")
		Directory directory = fileSystemManager.addDirectory("test", root);

		Directory documents = fileSystemManager.addDirectory("documents", root);
		@SuppressWarnings("unused")
		TextDocument textDocument = fileSystemManager.addTextFile("Hello.txt",
				documents, 20, TextEncoding.UTF8, 10);
		Directory official = fileSystemManager.addDirectory("official",
				documents);
		TextDocument pdfHello = fileSystemManager.addTextFile("Hello.pdf",
				official, 1400, TextEncoding.PDF, 20);
		@SuppressWarnings("unused")
		TextDocument pdfWorld = fileSystemManager.addTextFile("World.pdf",
				official, 1600, TextEncoding.PDF, 30);
		Directory draft = fileSystemManager.addDirectory("draft", documents);
		TextDocument wordHello = fileSystemManager.addTextFile("Hello.doc",
				draft, 2940, TextEncoding.WORD, 20);
		@SuppressWarnings("unused")
		TextDocument wordWorld = fileSystemManager.addTextFile("World.doc",
				draft, 3040, TextEncoding.WORD, 30);

		Set<FileSystemElement> matches = fileSystemManager.find("Hello.pdf");
		Assert.assertNotNull(matches);
		Assert.assertEquals(1, matches.size());
		Assert.assertTrue(matches.contains(pdfHello));

		matches = fileSystemManager.find("Hello.*");
		Assert.assertNotNull(matches);
		Assert.assertEquals(3, matches.size());
		Assert.assertTrue(matches.contains(pdfHello));
	}

	/**
	 * Test method for
	 * {@link com.prodyna.esd.filemanager.MyFileSystemManager#find(com.prodyna.esd.filemanager.SearchCriteria)}
	 * .
	 */
	@Test
	public void testFindSearchCriteria() {
		Directory root = fileSystemManager.getRoot();

		@SuppressWarnings("unused")
		Directory directory = fileSystemManager.addDirectory("test", root);

		Directory documents = fileSystemManager.addDirectory("documents", root);
		@SuppressWarnings("unused")
		TextDocument textDocument = fileSystemManager.addTextFile("Hello.txt",
				documents, 20, TextEncoding.UTF8, 10);
		Directory official = fileSystemManager.addDirectory("official",
				documents);
		TextDocument pdfHello = fileSystemManager.addTextFile("Hello.pdf",
				official, 1400, TextEncoding.PDF, 20);
		@SuppressWarnings("unused")
		TextDocument pdfWorld = fileSystemManager.addTextFile("World.pdf",
				official, 1600, TextEncoding.PDF, 30);
		Directory draft = fileSystemManager.addDirectory("draft", documents);
		TextDocument wordHello = fileSystemManager.addTextFile("Hello.doc",
				draft, 2940, TextEncoding.WORD, 20);
		@SuppressWarnings("unused")
		TextDocument wordWorld = fileSystemManager.addTextFile("World.doc",
				draft, 3040, TextEncoding.WORD, 30);

		SearchCriteria<FileSystemElement> criteria1 = new PageRangeCriteria<FileSystemElement>(
				15, 25);
		SearchCriteria<FileSystemElement> criteria2 = new NameSearchCriteria<FileSystemElement>(
				"Hello.pdf");
		SearchCriteria<FileSystemElement> andSearchCriteria = new SearchCriteriaBuilder<FileSystemElement>()
				.set(criteria1).and(criteria2).getSearchCriteria();
		Set<TextDocument> matches = fileSystemManager
				.findTextFiles(andSearchCriteria);
		Assert.assertNotNull(matches);
		Assert.assertEquals(1, matches.size());
		Assert.assertTrue(matches.contains(pdfHello));

		SearchCriteria<FileSystemElement> orSearchCriteria = new SearchCriteriaBuilder<FileSystemElement>()
				.set(criteria1).or(criteria2).getSearchCriteria();
		matches = fileSystemManager.findTextFiles(orSearchCriteria);
		Assert.assertNotNull(matches);
		Assert.assertEquals(2, matches.size());
		Assert.assertTrue(matches.contains(pdfHello));
		Assert.assertTrue(matches.contains(wordHello));

	}

}
