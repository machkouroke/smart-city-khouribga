package com.lop.smartcitykhouribga.models.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
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
    @ToString.Exclude
    private List<JobOffer> offers;
}
