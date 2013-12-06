/**
 * 
 */
package com.prodyna.esd.filemanager;

import com.prodyna.esd.filemanager.model.ArchiveFile;
import com.prodyna.esd.filemanager.model.CompressionType;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.ImageFile;
import com.prodyna.esd.filemanager.model.ImageType;
import com.prodyna.esd.filemanager.model.TextDocument;
import com.prodyna.esd.filemanager.model.impl.TextFileImpl.TextEncoding;

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
public class MyFileSystemManager {

    /**
     * @return
     */
    public Directory getRoot() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param string
     * @param root
     * @return
     */
    public Directory addDirectory(String string, Directory root) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param string
     * @param root
     * @param i
     * @param jar
     * @param j
     * @return
     */
    public ArchiveFile addArchiveFile(String string, Directory root, int i, CompressionType jar, int j) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param string
     * @param root
     * @param i
     * @param gif
     * @param j
     * @param k
     * @return
     */
    public ImageFile addImageFile(String string, Directory root, int i, ImageType gif, int j, int k) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param string
     * @param directory
     * @param i
     * @param utf8
     * @param numberOfPages
     * @return 
     */
    public TextDocument addTextFile(String string, Directory directory, int i, TextEncoding utf8, long numberOfPages) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 
     */
    public void list() {
        // TODO Auto-generated method stub
        
    }
}
