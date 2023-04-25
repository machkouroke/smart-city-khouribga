package com.lop.smartcitykhouribga.models.Keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOfferRelationKeys that = (UserOfferRelationKeys) o;
        return userId.equals(that.userId) && offerId.equals(that.offerId) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
