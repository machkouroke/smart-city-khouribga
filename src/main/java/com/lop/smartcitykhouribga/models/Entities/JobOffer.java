package com.lop.smartcitykhouribga.models.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/* TODO: Ecrire le code de la classe User */
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
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "domain")
    private String domain;

    @ManyToOne
    private Entreprise entreprise;

    @ManyToMany(mappedBy = "offers")
    private List<User> users;
}
