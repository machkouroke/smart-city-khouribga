package com.lop.smartcitykhouribga.models.Entities.DTO;

import lombok.*;

import java.util.Date;

@ToString
@NoArgsConstructor
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

}
