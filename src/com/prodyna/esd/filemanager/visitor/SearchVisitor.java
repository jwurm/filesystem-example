/**
 * 
 */
package com.prodyna.esd.filemanager.visitor;

import java.util.ArrayList;
import java.util.List;

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
public class SearchVisitor<T> extends FileSystemElementVisitor {

	private SearchCriteria<T> criteria;

	private List<FileSystemElement> matches;

	public SearchVisitor(SearchCriteria<T> criteria) {
		this.criteria = criteria;
		matches = new ArrayList<>();
	}

	public List<FileSystemElement> getMatches() {
		return matches;
	}

	@Override
	public void visit(ArchiveFile archiveFileImpl) {
		match(archiveFileImpl);
	}

	@Override
	public void visit(Directory directoryImpl) {
		match(directoryImpl);
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

	private void match(FileSystemElement element) {
		if (criteria.match(element)) {
			matches.add(element);
		}
	}

}
