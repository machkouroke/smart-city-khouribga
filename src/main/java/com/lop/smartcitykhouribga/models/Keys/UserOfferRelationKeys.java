package com.lop.smartcitykhouribga.models.Keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
public class UserOfferRelationKeys implements Serializable {

    @Column(name = "user_id")
    @NonNull
    private Long user_id;

    @Column(name = "offer_id")
    @NonNull
    private Long offer_id;

    @Column(name = "type")
    @NonNull
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOfferRelationKeys that = (UserOfferRelationKeys) o;
        return user_id.equals(that.user_id) && offer_id.equals(that.offer_id) && type.equals(that.type);
    }
}
