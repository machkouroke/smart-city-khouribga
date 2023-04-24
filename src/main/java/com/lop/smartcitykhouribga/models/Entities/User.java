package com.lop.smartcitykhouribga.models.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

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

    @Column(name = "mail")
    @NonNull
    private String mail;

    @Column(name = "cv")
    @NonNull
    private String cv;

    @Column(name = "role")
    @NonNull
    private String role;

    @Column(name = "password")
    @NonNull
    private String pwd;

    @Column(name = "photo")
    @NonNull
    private String photo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<UserOfferRelation> relatedOffers= new HashSet<>();
}
