package com.lop.smartcitykhouribga.models.Entities;


import com.lop.smartcitykhouribga.models.Keys.UserOfferRelationKeys;
import javax.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor

@Entity
@Table(name = "user_offer_relations")
public class UserOfferRelation {

    @EmbeddedId
    @Id
    private UserOfferRelationKeys id;

    @ManyToOne
    @MapsId("userId")
    @NonNull
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    User user;

    @ManyToOne
    @MapsId("offerId")
    @NonNull
    @JoinColumn(name = "offer_id")
    @ToString.Exclude
    JobOffer offer;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        UserOfferRelation that = (UserOfferRelation) o;
        return Objects.equals(id, that.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserOfferRelation{" +
                ", user=" + user +
                ", offer=" + offer +
                ", type=" + id.getType() +
                '}';
    }
}
