package com.maxgrayer.jsonimporter.models;

public class RockBandScoreResponse {
    private int status;

    private RockBandScoreSongs data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RockBandScoreSongs getData() {
        return data;
    }

    public void setData(RockBandScoreSongs data) {
        this.data = data;
    }

}
