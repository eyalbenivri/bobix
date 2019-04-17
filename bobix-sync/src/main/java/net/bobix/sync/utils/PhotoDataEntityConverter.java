package net.bobix.sync.utils;

import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import net.bobix.common.entities.PhotoData;

public class PhotoDataEntityConverter {
    public static PhotoData fromEntity(Entity entity) {
        if (entity == null) {
            return null;
        }
        PhotoData photoData = new PhotoData();
        photoData.setFilename(entity.getString("filename"));
        photoData.setContentHash(entity.getString("contentHash"));
        photoData.setCreated(entity.getTimestamp("created").toDate());
        photoData.setSize(entity.getLong("size"));
        FullEntity<IncompleteKey> dropboxEntity = entity.getEntity("dropboxData");
        PhotoData.DropboxData dropboxData = new PhotoData.DropboxData();
        dropboxData.setId(dropboxEntity.getString("id"));
        dropboxData.setPath(dropboxEntity.getString("path"));
        photoData.setDropboxData(dropboxData);
        
        return photoData;
    }
}
