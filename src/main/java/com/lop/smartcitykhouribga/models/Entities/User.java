package com.lop.smartcitykhouribga.models.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lop.smartcitykhouribga.models.Enum.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(force = true)
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


    @Column(name = "role")
    @NonNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "password")
    @NonNull
    private String pwd;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<UserOfferRelation> relatedOffers= new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String picture_link;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String cv_link;
}
