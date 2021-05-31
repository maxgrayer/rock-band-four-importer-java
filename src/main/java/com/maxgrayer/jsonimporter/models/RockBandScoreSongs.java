package com.maxgrayer.jsonimporter.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RockBandScoreSongs {
    private final Map<String, RockBandScoreData> scores;

    @JsonCreator
    public RockBandScoreSongs(@JsonProperty("scores") final Map<String, RockBandScoreData> scores) {
        this.scores = scores;
    }

    public Map<String, RockBandScoreData> getScores() {
        return scores;
    }
}
