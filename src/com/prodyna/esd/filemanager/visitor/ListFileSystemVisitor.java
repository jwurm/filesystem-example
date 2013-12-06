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
 * @author fassmus
 * 
 */
public class ListFileSystemVisitor extends FileSystemElementVisitor {
	private int depth = 0;

	@Override
	public void visit(ArchiveFile archiveFileImpl) {
		printElement(archiveFileImpl);
	}

	@Override
	public void visit(Directory directoryImpl) {
		printElement(directoryImpl);
		depth = depth + 1;
		super.visit(directoryImpl);
		depth = depth - 1;
	}

	@Override
	public void visit(ImageFile imageFileImpl) {
		printElement(imageFileImpl);
	}

	@Override
	public void visit(TextDocument textFileImpl) {
		printElement(textFileImpl);
	}

	/**
	 * @param archiveFileImpl
	 */
	private void printElement(FileSystemElement element) {
		for (int i = 0; i < depth; i++) {
			System.out.print("\t");
		}
		System.out.println(element.getName());
	}

}
