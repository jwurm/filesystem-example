/**
 * 
 */
package com.prodyna.esd.filemanager;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.ImageType;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding;
import com.prodyna.esd.filemanager.observer.FileSystemListener;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>FileSystemManager.java <b>Created:</b>
 * 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public interface FileSystemManager {

    void addListener(FileSystemListener fileSystemListener);

	void removeListener(FileSystemListener listener);

	Directory getRoot();

	Directory addDirectory(String string, Directory root);

	TextDocument addTextFile(String string, Directory root, int i,
			TextEncoding utf8, long j);

	ImageFile addImageFile(String string, Directory directory, int i,
			ImageType gif, int j, int k);

	void removeFileSystemElement(TextDocument textDocument);

	void removeFileSystemElement(ImageFile imageFile);

	void removeFileSystemElement(Directory directory);
}
