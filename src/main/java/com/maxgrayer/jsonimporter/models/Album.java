package com.maxgrayer.jsonimporter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Album {
    private int id;
    private long updated;
    private String article;
    private String name;
    private int year;
    private int coverId;
    private int[] songs;
    private int track;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(final long updated) {
        this.updated = updated;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(final String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    @JsonProperty("cover")
    public int getCoverId() {
        return coverId;
    }

    public void setCoverId(final int coverId) {
        this.coverId = coverId;
    }

    public int[] getSongs() {
        return songs;
    }

    public void setSongs(final int[] songs) {
        this.songs = songs;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(final int track) {
        this.track = track;
    }
}
