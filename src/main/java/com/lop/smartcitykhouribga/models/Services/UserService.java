package com.lop.smartcitykhouribga.models.Services;

import com.lop.smartcitykhouribga.models.Entities.JobOffer;
import com.lop.smartcitykhouribga.models.Entities.User;
import com.lop.smartcitykhouribga.models.Entities.UserOfferRelation;
import com.lop.smartcitykhouribga.models.Keys.UserOfferRelationKeys;
import com.lop.smartcitykhouribga.models.Repositories.JobOfferRepository;
import com.lop.smartcitykhouribga.models.Repositories.RelationRepository;
import com.lop.smartcitykhouribga.models.Repositories.UserRepository;
import com.lop.smartcitykhouribga.utilities.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    public final PasswordEncoder encoder;

    private final UserRepository userRepository;
    private final RelationRepository relationRepository;

    private final FirebaseService firebaseService;

    private final FileUtility fileUtility;


    @Autowired
    public UserService(UserRepository userRepository,
                       JobOfferRepository jobOfferRepository,
                       PasswordEncoder encoder,
                       RelationRepository relationRepository,
                       FirebaseService firebaseService,
                       FileUtility fileUtility) {

        this.userRepository = userRepository;
        this.encoder = encoder;
        this.relationRepository = relationRepository;
        this.firebaseService = firebaseService;
        this.fileUtility = fileUtility;
    }

    public User save(User toSave) {
        User newUser = this.userRepository.save(toSave);
        return newUser;
    }

    public void register(User user, MultipartFile cv, MultipartFile photo) throws IOException {
        fileUtility.saveCv(user, cv);
        fileUtility.saveProfilePicture(user, photo);

        user.setPwd(encoder.encode(user.getPwd()));

        save(user);
    }

    public UserOfferRelation saveRelation(UserOfferRelation uor) {

        return this.relationRepository.save(uor);
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


    public void deleteRelation(UserOfferRelation uor){
        System.out.println("Appel de la fonction de suppression");
        relationRepository.delete(uor);
    }
    public void deleteRelationById(UserOfferRelationKeys key){
        System.out.println("Appel de la fonction de suppression par id");
        UserOfferRelation uor= relationRepository.findById(key).orElse(null);
        if (uor == null){
            throw  new IndexOutOfBoundsException();
        }
        System.out.println("Recherche "+uor.getId().getType());
        relationRepository.delete(uor);
    }

}
