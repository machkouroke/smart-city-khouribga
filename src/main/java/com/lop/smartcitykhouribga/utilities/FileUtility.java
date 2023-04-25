package com.lop.smartcitykhouribga.utilities;

import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Services.FirebaseService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileUtility {
    private final FirebaseService firebaseService;

    @Autowired
    public FileUtility(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    public void test() {
        System.out.println("Current Path: " + System.getProperty("user.dir"));

    }

    public void saveCv(User user, MultipartFile cv) throws IOException {
        Path path = Paths.get("temps/");
        boolean notTempDirectoryExists = !(Files.exists(path));
        System.out.println("Path" + path);

        if (notTempDirectoryExists) {
            Files.createDirectories(path);
        }
        if (validateFiles(cv)) {

            String extension = FilenameUtils.getExtension(cv.getOriginalFilename());
            String cvPathname = System.getProperty("user.dir")+ File.separator+ path + File.separator + user.getName() + "Cv." + extension;
            System.out.println("CVPathname: " + cvPathname );
            cv.transferTo(new File(cvPathname));
            firebaseService.uploadFile(Path.of(cvPathname), "User/Cv");
        }

    }

    public void saveProfilePicture(User user, MultipartFile photo) throws IOException {
        Path path = Paths.get("temps/");
        boolean notTempDirectoryExists = !(Files.exists(path));

        if (notTempDirectoryExists) {
            Files.createDirectories(path);
        }
        if (validateFiles(photo)) {
            String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
            String photoPathname = System.getProperty("user.dir")+ File.separator+ path + File.separator + user.getName() + "Picture." + extension;
            System.out.println(photoPathname);
            photo.transferTo(new File(photoPathname));

            firebaseService.uploadFile(Path.of(photoPathname), "User/Pictures");
        }
    }

    public boolean validateFiles(MultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        return extension != null && (
                extension.equals("png")
                        || extension.equals("jpg")
                        || extension.equals("jpeg")
                        || extension.equals("pdf"));
    }
}
