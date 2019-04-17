package net.bobix.common.entities;

import java.util.Date;

public class PhotoData {
    private DropboxData dropboxData;
    private String filename;
    private long size;
    private String contentHash;
    private Date created;
    
    public static PhotoData fromDropboxFile(String dropboxId, String path, String name, long size, String contentHash) {
        PhotoData photoData = new PhotoData();
        photoData.dropboxData = new DropboxData();
        photoData.dropboxData.setId(dropboxId);
        photoData.dropboxData.setPath(path);
        photoData.filename = name;
        photoData.size = size;
        photoData.contentHash = contentHash;
        return photoData;
    }
    
    public long getSize() {
        return size;
    }
    
    public void setSize(long size) {
        this.size = size;
    }
    
    public String getContentHash() {
        return contentHash;
    }
    
    public void setContentHash(String contentHash) {
        this.contentHash = contentHash;
    }
    
    public String getFilename() {
        return filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public DropboxData getDropboxData() {
        return dropboxData;
    }
    
    public void setDropboxData(DropboxData dropboxData) {
        this.dropboxData = dropboxData;
    }
    
    public Date getCreated() {
        return created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    
    @Override
    public String toString() {
        return "PhotoData{" +
                       ", dropboxData='" + dropboxData + '\'' +
                       ", filename='" + filename + '\'' +
                       ", size=" + size +
                       ", contentHash='" + contentHash + '\'' +
                       '}';
    }
    
    public static class DropboxData {
        private String id;
        private String path;
        
        public String getId() {
            return id;
        }
        
        public void setId(String id) {
            this.id = id;
        }
        
        public String getPath() {
            return path;
        }
        
        public void setPath(String path) {
            this.path = path;
        }
        
        
    }
}
