package webservice.carros.domain;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import webservice.carros.api.upload.UploadInput;

@Service
public class FirebaseStorageService {

    @PostConstruct
    private void init() throws IOException {

        if (FirebaseApp.getApps().isEmpty()) {

            InputStream in = FirebaseStorageService.class.getResourceAsStream("/serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(in))
                    .setStorageBucket("carrosapi-66d11.appspot.com")
                    .setDatabaseUrl("https://carrosapi-66d11.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);

        }

    }

    public String upload(UploadInput uploadInput) {
        
        Bucket bucket = StorageClient.getInstance().bucket();
        
        byte[] bytes = Base64.getDecoder().decode(uploadInput.getBase64());
        String fileName = uploadInput.getFileName();
        Blob blob = bucket.create(fileName, bytes, uploadInput.getMimeType());
        
        blob.createAcl(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
        return String.format("https://storage.googleapis.com/%s/%s", bucket.getName(),fileName);
    }

}
