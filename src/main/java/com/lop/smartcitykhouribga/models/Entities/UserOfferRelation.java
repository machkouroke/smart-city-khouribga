package com.lop.smartcitykhouribga.models.Entities;


import com.lop.smartcitykhouribga.models.Keys.UserOfferRelationKeys;
import javax.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
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
    User user;

    @ManyToOne
    @MapsId("offerId")
    @NonNull
    @JoinColumn(name = "offer_id")
    JobOffer offer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOfferRelation that = (UserOfferRelation) o;
        return Objects.equals(id, that.id) && user.equals(that.user) && offer.equals(that.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, offer);
    }
}
