package com.lop.smartcitykhouribga.models.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
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

    @Column(name = "postedAt")
    @NonNull
    private Date postedAt;

    @ManyToOne
    private Entreprise entreprise;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<UserOfferRelation> relatedUsers= new HashSet<>();
}
