package com.lop.smartcitykhouribga.models.Entities;

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
@Table(name = "offers")
public class JobOffer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @NonNull
    private Long id;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "description")
    @NonNull
    private String description;

    @Column(name = "type")
    @NonNull
    private String type;

    @Column(name = "domain")
    @NonNull
    private String domain;

    @ManyToOne
    private Entreprise entreprise;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<UserOfferRelation> relatedUsers= new HashSet<>();
}
