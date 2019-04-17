package net.bobix.sync.utils;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import net.bobix.common.entities.PhotoData;

public class DatabaseHelper {
    // Create an authorized Datastore service using Application Default Credentials.
    private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    
    // Create a Key factory to construct keys associated with this project.
    private final KeyFactory keyFactory = datastore.newKeyFactory().setKind("PhotoData");
    
    public PhotoData getPhotoDataByDropboxId(String dropboxId) {
        Key key = keyFactory.newKey(dropboxId);
        return datastore.get(key).;
    }
}
