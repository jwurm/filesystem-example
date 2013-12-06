/**
 * 
 */
package com.prodyna.esd.filemanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.prodyna.esd.filemanager.model.ArchiveFile;
import com.prodyna.esd.filemanager.model.CompressionType;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.FileSystemElement;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.ImageType;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.model.impl.ArchiveFileImpl;
import com.prodyna.esd.filemanager.model.impl.DirectoryImpl;
import com.prodyna.esd.filemanager.model.impl.ImageFileImpl;
import com.prodyna.esd.filemanager.model.impl.TextFileImpl;
import com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding;
import com.prodyna.esd.filemanager.observer.FileSystemListener;
import com.prodyna.esd.filemanager.visitor.SearchVisitor;
import com.prodyna.esd.filesystem.filemanager.search.SearchCriteria;

/**
 * 
 * <b>Project:</b> filesystem-example</br> <b>Classname:</b>
 * </br>MyFileSystemManager.java <b>Created:</b>
 * 06.12.2013</br>
 * 
 * @author Jens Wurm
 * 
 *         Beschreibung: 
 */
public class MyFileSystemManager implements FileSystemManager{

    private Directory root;

    /**
     * @return
     */
    public Directory getRoot() {
        if(root==null){
            root=new DirectoryImpl("/", null, new ArrayList<FileSystemElement>());
        }
        return root;
    }

    /**
     * @param name
     * @param parent
     * @return
     */
    public Directory addDirectory(String name, Directory parent) {
        return new DirectoryImpl(name, parent, new ArrayList<FileSystemElement>());
    }

    /**
     * @param name
     * @param parent
     * @param size
     * @param compressionType
     * @param uncompressedSize
     * @return
     */
    public ArchiveFile addArchiveFile(String name, Directory parent, int size, CompressionType compressionType, int uncompressedSize) {
        ArchiveFileImpl ret = new ArchiveFileImpl(name, parent, size, compressionType, uncompressedSize);
        parent.add(ret);
        return ret;
    }

    /**
     * @param name
     * @param parent
     * @param size
     * @param type
     * @param width
     * @param k
     * @return
     */
    public ImageFile addImageFile(String name, Directory parent, int size, ImageType type, int width, int height) {
        ImageFileImpl ret = new ImageFileImpl(name, parent, size, type, width, height);
        parent.add(ret);
        return ret;
    }

    /**
     * @param name
     * @param directory
     * @param size
     * @param encoding
     * @param numberOfPages
     * @return 
     */
    public TextDocument addTextFile(String name, Directory directory, int size, TextEncoding encoding, long numberOfPages) {
        TextFileImpl ret = new TextFileImpl(name, directory, size, encoding, numberOfPages);
        directory.add(ret);
        return ret;
    }

    /**
     * 
     */
    public void list() {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.prodyna.esd.filemanager.observer.FileSystemManager#addListener(com.prodyna.esd.filemanager.observer.FileSystemListener)
     */
    @Override
    public void addListener(FileSystemListener fileSystemListener) {
        Directory root = getRoot();
        root.addListener(fileSystemListener);
    }

    /**
     * @param andSearchCriteria
     * @return
     */
    public Set<TextDocument> findTextFiles(SearchCriteria<TextDocument> criteria) {
        SearchVisitor<TextDocument> visitor = new SearchVisitor<>(criteria);
        getRoot().accept(visitor);
        List<FileSystemElement> matches = visitor.getMatches();
        //TODO generics korrigieren
        HashSet<TextDocument> ret = new HashSet<TextDocument>((Collection<? extends TextDocument>) matches);
        return ret;
    }

	@Override
	public void removeListener(FileSystemListener listener) {
        Directory root = getRoot();
        root.removeListener(listener);
	}

	@Override
	public void removeFileSystemElement(FileSystemElement fse) {
	    Directory parent = fse.getParentDirectory();
	    parent.remove(fse);
	}


}
