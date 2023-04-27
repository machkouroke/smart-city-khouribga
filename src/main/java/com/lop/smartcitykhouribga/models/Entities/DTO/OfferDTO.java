package com.lop.smartcitykhouribga.models.Entities.DTO;

import lombok.*;

import java.util.Date;
import java.util.List;

@ToString
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
public class OfferDTO {

    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private String type;
    @NonNull
    private String domain;
    @NonNull
    private Date postedAt;
    @NonNull
    private String enterpriseName;
    @NonNull
    private String contact;

    private List<String> tag;

    private String picture;

    private String location;

    private Long likesNumber;

}
