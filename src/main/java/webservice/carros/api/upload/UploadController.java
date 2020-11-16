
package webservice.carros.api.upload;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webservice.carros.domain.FirebaseStorageService;


@RestController
@RequestMapping("/api/v1/carros/upload")
public class UploadController {
    
    @Autowired
    private FirebaseStorageService uploadService;
    
    
    
    @PostMapping
    public ResponseEntity upload(@RequestBody UploadInput uploadInput) throws IOException{
        String url = uploadService.upload(uploadInput);
        return ResponseEntity.ok(new UploadOutput(url));    
    }
    
}
