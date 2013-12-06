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
public class FileSearchVisitor extends SearchVisitor<FileSystemElement> {

	public FileSearchVisitor(SearchCriteria<FileSystemElement> criteria) {
		super(criteria);
	}

	@Override
	public void visit(ArchiveFile archiveFileImpl) {
		match(archiveFileImpl);
	}

	@Override
	public void visit(Directory directoryImpl) {
		super.visit(directoryImpl);
	}

	@Override
	public void visit(ImageFile imageFileImpl) {
		match(imageFileImpl);
	}

	@Override
	public void visit(TextDocument textFileImpl) {
		match(textFileImpl);
	}

}
