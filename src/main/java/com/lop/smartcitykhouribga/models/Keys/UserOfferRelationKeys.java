package com.lop.smartcitykhouribga.models.Keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class UserOfferRelationKeys implements Serializable {

    @Column(name = "user_id")
    @NonNull
    private Long userId;

    @Column(name = "offer_id")
    @NonNull
    private Long offerId;

    @Column(name = "type")
    @NonNull
    private String type;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        UserOfferRelationKeys that = (UserOfferRelationKeys) o;
        return userId.equals(that.userId) && offerId.equals(that.offerId) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, offerId, type);
    }

}
