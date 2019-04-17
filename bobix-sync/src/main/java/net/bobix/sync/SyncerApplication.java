package net.bobix.sync;

import net.bobix.common.entities.PhotoData;
import net.bobix.sync.utils.DatabaseHelper;
import net.bobix.sync.utils.DropboxHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SyncerApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory
                                        .getLogger(SyncerApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(SyncerApplication.class, args);
    }
    
    
    @Override
    public void run(String... args) throws Exception {
        LOG.info("Getting files from Dropbox");
        DropboxHelper dropboxHelper = new DropboxHelper();
        Iterable<PhotoData> files = dropboxHelper.getFiles();
        files.forEach(x -> LOG.info(x.toString()));
        DatabaseHelper databaseHelper = new DatabaseHelper();
        Iterable<PhotoData> existing = databaseHelper.getAllPhotos();
        
    }
}
