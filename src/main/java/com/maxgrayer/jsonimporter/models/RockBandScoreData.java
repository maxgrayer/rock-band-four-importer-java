package com.maxgrayer.jsonimporter.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RockBandScoreData {
    private final boolean wishList;
    private final boolean owned;
    private final int playCount;

    @JsonCreator
    public RockBandScoreData(@JsonProperty("w") final boolean wishList, @JsonProperty("o") final boolean owned,
            @JsonProperty("pl") final int playCount) {
        this.wishList = wishList;
        this.owned = owned;
        this.playCount = playCount;
    }

    public boolean isWishList() {
        return wishList;
    }

    public boolean isOwned() {
        return owned;
    }

    public int getPlayCount() {
        return playCount;
    }

}
