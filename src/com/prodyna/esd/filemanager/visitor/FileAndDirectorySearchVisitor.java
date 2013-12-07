/**
 * 
 */
package com.prodyna.esd.filemanager.visitor;

import com.prodyna.esd.filemanager.model.ArchiveFile;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filesystem.filemanager.search.SearchCriteria;

/**
 * @author fassmus
 * 
 */
public class FileAndDirectorySearchVisitor extends
		SearchVisitor<FileSystemElement> {

	public FileAndDirectorySearchVisitor(
			SearchCriteria<FileSystemElement> criteria) {
		super(criteria);
	}

	@Override
	public void visit(ArchiveFile archiveFileImpl) {
		matches(archiveFileImpl);
	}

	@Override
	public void visit(Directory directoryImpl) {
		matches(directoryImpl);
		super.visit(directoryImpl);
	}

	@Override
	public void visit(ImageFile imageFileImpl) {
		matches(imageFileImpl);
	}

	@Override
	public void visit(TextDocument textFileImpl) {
		matches(textFileImpl);
	}

}
