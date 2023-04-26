package com.lop.smartcitykhouribga.models.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lop.smartcitykhouribga.models.Enum.Role;
import com.lop.smartcitykhouribga.models.Services.FirebaseService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.actuate.beans.BeansEndpoint;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
@Entity @Configurable
@Table(name = "users")
public class User implements UserDetails {

    @Autowired @Transient
    FirebaseService firebaseService;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "surname")
    @NonNull
    private String surname;

    @Column(name = "mail", unique = true)
    @NonNull
    private String mail;


    @Column(name = "role")
    @NonNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "password")
    @NonNull
    private String pwd;

    @Column(name="cv_extensinon") @NonNull
    private String cvExtension;

    @Column(name = "pic_extension") @NonNull
    private String picExtension;


    @OneToMany(mappedBy = "user",  orphanRemoval = true)
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<UserOfferRelation> relatedOffers = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role));
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public String getUsername() {
        return this.mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getCvLink(){
        String cvPath= "/User/Cv/"+ this.getMail()+"."+ this.getCvExtension();
        return firebaseService.getFileUrl(cvPath);
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getPictureLink(){
        String picPath= "/User/Pictures/"+ this.getMail()+"."+ this.getPicExtension();
        return firebaseService.getFileUrl(picPath);
    }
}
