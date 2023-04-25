package com.lop.smartcitykhouribga.models.Services;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Repositories.JobOfferRepository;
import com.lop.smartcitykhouribga.models.Repositories.RelationRepository;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RelationRepository relationRepository;

    private final FirebaseService firebaseService;

    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       JobOfferRepository jobOfferRepository,
                       RelationRepository relationRepository,
                       FirebaseService firebaseService, PasswordEncoder encoder) {

        this.userRepository = userRepository;
        this.relationRepository = relationRepository;
        this.firebaseService = firebaseService;
        this.encoder = encoder;
    }

    public User save(User toSave) {
        return this.userRepository.save(toSave);
    }

    public void register(User user, MultipartFile cv, MultipartFile photo) throws IOException {
        uploadUserCV(user, cv);
        uploadUserPhoto(user, photo);
        user.setPwd(encoder.encode(user.getPwd()));
        save(user);
    }

    public UserOfferRelation saveRelation(UserOfferRelation toSave) {
        return this.relationRepository.save(toSave);
    }

    public void delete(Long id) {
        User user = this.userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new IndexOutOfBoundsException();
        }
        this.userRepository.deleteById(id);
    }

    public User findById(Long id) {
        User user = this.userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new IndexOutOfBoundsException();
        }
        return user;
    }

    public List<User> findAll() {
        return (List<User>) this.userRepository.findAll();
    }

    public Set<JobOffer> findOffersRelatedToUser(Long id, String type) {
        User user = this.userRepository.findById(id).orElse(null);
        return user.getRelatedOffers()
                .stream()
                .filter(relatedOffer ->
                        relatedOffer.getId()
                                .getType()
                                .equals(type))
                .map(
                        UserOfferRelation::getOffer
                )
                .collect(Collectors.toSet());
    }

    public void uploadUserCV(User user, MultipartFile cv) throws IOException {
        if (validateFiles(cv)) {
            String extension = FilenameUtils.getExtension(cv.getOriginalFilename());
            String cvPathname = "C:\\Users\\USER\\Desktop\\" +
                    "IID 2\\Mes cours\\Semestre 2\\JEE\\TP\\cv\\" + user.getName() + "." + extension;
            cv.transferTo(new File(cvPathname));
        }
    }

    public void uploadUserPhoto(User user, MultipartFile photo) throws IOException {
        if (validateFiles(photo)) {
            String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
            String photoPathname = "C:\\Users\\USER\\Desktop\\" +
                    "IID 2\\Mes cours\\Semestre 2\\JEE\\TP\\photo\\" + user.getName() + "." + extension;
            photo.transferTo(new File(photoPathname));
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
