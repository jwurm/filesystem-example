/**
 * 
 */
package com.prodyna.esd.filemanager.visitor;

import com.prodyna.esd.filemanager.model.ArchiveFile;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.TextDocument;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>FileSystemElementVisitor.java <b>Created:</b> 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung:
 */
public class FileSystemElementVisitor {

	/**
	 * @param archiveFileImpl
	 */
	public void visit(ArchiveFile archiveFileImpl) {
	}

	/**
	 * @param directoryImpl
	 */
	public void visit(Directory directoryImpl) {
		for (FileSystemElement element : directoryImpl.getElements()) {
			element.accept(this);
		}
	}

	/**
	 * @param imageFileImpl
	 */
	public void visit(ImageFile imageFileImpl) {
	}

	/**
	 * @param textFileImpl
	 */
	public void visit(TextDocument textFileImpl) {
	}

}
