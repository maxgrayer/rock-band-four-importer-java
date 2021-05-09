package com.maxgrayer.jsonimporter.models;

public class Artist {
    private int id;
    private String article;
    private String name;
    private int[] songs;
    private long updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getSongs() {
        return songs;
    }

    public void setSongs(int[] songs) {
        this.songs = songs;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }
}
