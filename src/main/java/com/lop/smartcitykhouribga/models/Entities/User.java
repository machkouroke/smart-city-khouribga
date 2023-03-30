package com.lop.smartcitykhouribga.models.Entities;

import lombok.*;

/* TODO: Ecrire le code de la classe User */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private String id;
    private String name;
    private String surname;
    private String mail;
    private String cv;
    private String role;
}
