package com.maxgrayer.jsonimporter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RockBandData {
    private int count;
    private RockBandSong[] songs;

    @JsonProperty("total_entries")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public RockBandSong[] getSongs() {
        return songs;
    }

    public void setSongs(RockBandSong[] songs) {
        this.songs = songs;
    }

}
