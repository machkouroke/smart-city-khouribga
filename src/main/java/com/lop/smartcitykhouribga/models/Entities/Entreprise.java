package com.lop.smartcitykhouribga.models.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity @Table(name = "entreprise")
public class Entreprise {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "location")
    @NonNull
    private String location;

    @OneToMany(mappedBy = "entreprise")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<JobOffer> offers;
}
