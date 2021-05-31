package com.maxgrayer.jsonimporter.models;

public class RockBandResponse {
    private int status;

    private RockBandData data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RockBandData getData() {
        return data;
    }

    public void setData(RockBandData data) {
        this.data = data;
    }
}
