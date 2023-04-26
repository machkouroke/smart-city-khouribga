package com.lop.smartcitykhouribga.models.Entities.DTO;

import com.lop.smartcitykhouribga.models.Enum.Role;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@ToString
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
public class UserDTO {
    @NonNull
    private Long id;
    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String mail;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NonNull
    private String pwd;

    @NonNull
    private String picLink;

    @NonNull
    private String cvLink;

    private String cvExtension;

    private String picExtension;
}
