package com.lop.smartcitykhouribga.models.Services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;


@Service
public class FirebaseService {
    private static final String CREDENTIALS_PATH = "credentials.json";
    private static final String GCLOUD_BUCKET = "smart-city-915d9.appspot.com";

    private Bucket bucket;

    public FirebaseService() {
        try {
            /* print current path */
            System.out.println("Current Path: " + System.getProperty("user.dir"));


            FileInputStream serviceAccount = new FileInputStream(CREDENTIALS_PATH);
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .setStorageBucket(GCLOUD_BUCKET)
                    .build();
            FirebaseApp.initializeApp(options);
            bucket = StorageClient.getInstance().bucket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void uploadFile(Path fileName, String dstPath) throws IOException {
        /* Create automatocally whith the corresponding file name type */
        bucket.create(String.format("%s/%s", dstPath, fileName.getFileName()),
                new FileInputStream(fileName.toFile()), getLocalFileContentType(fileName));
    }

    public String getLocalFileContentType(Path filePath) throws IOException {
        String contentType = Files.probeContentType(filePath);
        return contentType == null ? "application/octet-stream" : contentType;
    }

    /**
     * @param filePath the path of the file in the bucket
     * @return the url of the file
     */
    public String getFileUrl(String filePath) {
        return bucket.get(filePath).signUrl(1000, TimeUnit.DAYS).toString();
    }
}
