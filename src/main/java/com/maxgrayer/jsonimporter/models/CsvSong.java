package com.maxgrayer.jsonimporter.models;

public class CsvSong {
    private String title;
    private String artist;
    private String year;
    private String genre;
    private String packName;
    private String releaseDate;
    private String familyFriendly;
    private String rb3Features;

    public CsvSong(final String title, final String artist, final String year, final String genre,
            final String packName, final String releaseDate, final String familyFriendly, final String rb3Features) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.packName = packName;
        this.releaseDate = releaseDate;
        this.familyFriendly = familyFriendly;
        this.rb3Features = rb3Features;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFamilyFriendly() {
        return familyFriendly;
    }

    public void setFamilyFriendly(String familyFriendly) {
        this.familyFriendly = familyFriendly;
    }

    public String getRb3Features() {
        return rb3Features;
    }

    public void setRb3Features(String rb3Features) {
        this.rb3Features = rb3Features;
    }
}
