package com.maxgrayer.jsonimporter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class PersistedSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String artist;
    private String genre;
    private int year;
    private int length;
    private int guitar;
    private int drum;
    private int vocal;
    private int bass;
    private boolean isOwned;
    private boolean onWishlist;

    protected PersistedSong() {
    }

    public PersistedSong(String title, String artist, String genre, int year, int length, int guitar, int drum,
            int vocal, int bass, boolean isOwned, boolean onWishlist) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.length = length;
        this.guitar = guitar;
        this.drum = drum;
        this.vocal = vocal;
        this.bass = bass;
        this.isOwned = isOwned;
        this.onWishlist = onWishlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getGuitar() {
        return guitar;
    }

    public void setGuitar(int guitar) {
        this.guitar = guitar;
    }

    public int getDrum() {
        return drum;
    }

    public void setDrum(int drum) {
        this.drum = drum;
    }

    public int getVocal() {
        return vocal;
    }

    public void setVocal(int vocal) {
        this.vocal = vocal;
    }

    public int getBass() {
        return bass;
    }

    public void setBass(int bass) {
        this.bass = bass;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }

    public boolean isOnWishlist() {
        return onWishlist;
    }

    public void setOnWishlist(boolean onWishlist) {
        this.onWishlist = onWishlist;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((artist == null) ? 0 : artist.toLowerCase().hashCode());
        result = prime * result + ((title == null) ? 0 : title.toLowerCase().hashCode());
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersistedSong other = (PersistedSong) obj;
        if (artist == null) {
            if (other.artist != null)
                return false;
        } else if (!artist.equalsIgnoreCase(other.artist))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equalsIgnoreCase(other.title))
            return false;
        if (year != other.year)
            return false;
        return true;
    }
}
