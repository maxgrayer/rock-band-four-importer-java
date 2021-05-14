package com.maxgrayer.jsonimporter.models;

public class RbdbSong {
    private int id;
    private String article;
    private String name;
    private int year;
    private int artist;
    private long updated;
    private String shortname;
    /* Enum: [ 0, F, M, X ] */
    /* 0 = none; F = female; M = male; X = non-binary */
    private int gender;
    private int vocalParts;
    /* unknown id link */
    private int vocalPercussion;
    private boolean cover;
    private boolean markup;
    private int bpm;
    private long duration;
    private int availability;
    private String released;
    private String delisted;
    private int genre;
    private boolean ending;
    private String spotifyId;
    private Instruments tiers;
    private Instruments ranks;
    private Album album;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
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

    public int getArtist() {
        return artist;
    }

    public void setArtist(final int artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(final Album album) {
        this.album = album;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(final long updated) {
        this.updated = updated;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(final String shortname) {
        this.shortname = shortname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(final int gender) {
        this.gender = gender;
    }

    public int getVocalParts() {
        return vocalParts;
    }

    public void setVocalParts(final int vocalParts) {
        this.vocalParts = vocalParts;
    }

    public int getVocalPercussion() {
        return vocalPercussion;
    }

    public void setVocalPercussion(final int vocalPercussion) {
        this.vocalPercussion = vocalPercussion;
    }

    public boolean isCover() {
        return cover;
    }

    public void setCover(final boolean cover) {
        this.cover = cover;
    }

    public boolean isMarkup() {
        return markup;
    }

    public void setMarkup(final boolean markup) {
        this.markup = markup;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(final int bpm) {
        this.bpm = bpm;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(final long duration) {
        this.duration = duration;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(final int availability) {
        this.availability = availability;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(final String released) {
        this.released = released;
    }

    public String getDelisted() {
        return delisted;
    }

    public void setDelisted(final String delisted) {
        this.delisted = delisted;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(final int genre) {
        this.genre = genre;
    }

    public boolean isEnding() {
        return ending;
    }

    public void setEnding(final boolean ending) {
        this.ending = ending;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(final String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public Instruments getTiers() {
        return tiers;
    }

    public void setTiers(final Instruments tiers) {
        this.tiers = tiers;
    }

    public Instruments getRanks() {
        return ranks;
    }

    public void setRanks(final Instruments ranks) {
        this.ranks = ranks;
    }
}
