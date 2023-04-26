package com.lop.smartcitykhouribga.models.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(force = true)
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

    @Column(name = "contact")
    @NonNull
    private String contact;

    @ElementCollection
    @CollectionTable(name = "tags")
    private List<String> tag;

    @ManyToOne
    @ToString.Exclude
    private Entreprise entreprise;

    @OneToMany(mappedBy = "offer",  orphanRemoval = true)
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<UserOfferRelation> relatedUsers= new HashSet<>();
}
