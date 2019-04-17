package net.bobix.sync.utils;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import net.bobix.common.entities.PhotoData;

import java.util.ArrayList;
import java.util.List;

public class DropboxHelper {
    private static final String DROPBOX_APP_KEY = "jg1gx059a10tnxv";
    private static final String DROPBOX_APP_SECRET = "0f1s72w9hwama7n";
    private static final String DROPBOX_SELF_TOKEN = "RZJU6x4YpDwAAAAAAADleI6E9WLEjSLAEs3or_RD0EYk0-WdMwvyp7SZWnCVLxiW";
    private static final String PICTURES_LOCATION = "/Eyal Synced Folder/Pictures/Lightroom CC Saved Photos";
    private final DbxClientV2 client;
    
    public DropboxHelper() {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        client = new DbxClientV2(config, DROPBOX_SELF_TOKEN);
    }
    
    
    public Iterable<PhotoData> getFiles() throws DbxException {
        List<PhotoData> output = new ArrayList<>();
        ListFolderResult result = client.files().listFolder(PICTURES_LOCATION);
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
                if (metadata.getClass() == FileMetadata.class) {
                    output.add(metadata2File((FileMetadata) metadata));
                }
            }
            
            if (!result.getHasMore()) {
                break;
            }
            
            result = client.files().listFolderContinue(result.getCursor());
        }
        return output;
    }
    
    private PhotoData metadata2File(FileMetadata metadata) {
        return PhotoData.fromDropboxFile(
                metadata.getId(),
                metadata.getPathLower(),
                metadata.getName(),
                metadata.getSize(),
                metadata.getContentHash());
    }
    
}
