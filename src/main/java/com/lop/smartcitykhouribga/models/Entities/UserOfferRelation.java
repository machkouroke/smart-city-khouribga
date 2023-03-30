package com.lop.smartcitykhouribga.models.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "user_offer_relations")
public class UserOfferRelation {
}
