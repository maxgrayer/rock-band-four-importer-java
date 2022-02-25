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
    private int year;
    private String album;
    private int trackNum;
    private String genre;
    private int duration;
    private String shortname;
    private int sortRankBass;
    private int sortRankGuitar;
    private int sortRankVocal;
    private int sortRankDrum;
    private String sortAlbum;
    private String sortArtist;
    private String sortTitle;
    private String awsArtworkLink;
    private String releaseDate;
    private String xboxStoreLink;
    private int bpm;
    private int sortRankBand;
    private int displayRankDrums;
    private int displayRankVocal;
    private int displayRankGuitar;
    private int displayRankBass;
    private int displayRankBand;
    private boolean isOwned;
    private boolean onWishlist;

    protected PersistedSong() {
    }

    public PersistedSong(String title, String artist, int year, String album, int trackNum, String genre, int duration,
            String shortname, int sortRankBass, int sortRankGuitar, int sortRankVocal, int sortRankDrum,
            String sortAlbum, String sortArtist, String sortTitle, String awsArtworkLink, String releaseDate,
            String xboxStoreLink, int bpm, int sortRankBand, int displayRankDrums, int displayRankVocal,
            int displayRankGuitar, int displayRankBass, int displayRankBand, boolean isOwned, boolean onWishlist) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.album = album;
        this.trackNum = trackNum;
        this.genre = genre;
        this.duration = duration;
        this.shortname = shortname;
        this.sortRankBass = sortRankBass;
        this.sortRankGuitar = sortRankGuitar;
        this.sortRankVocal = sortRankVocal;
        this.sortRankDrum = sortRankDrum;
        this.sortAlbum = sortAlbum;
        this.sortArtist = sortArtist;
        this.sortTitle = sortTitle;
        this.awsArtworkLink = awsArtworkLink;
        this.releaseDate = releaseDate;
        this.xboxStoreLink = xboxStoreLink;
        this.bpm = bpm;
        this.sortRankBand = sortRankBand;
        this.displayRankDrums = displayRankDrums;
        this.displayRankVocal = displayRankVocal;
        this.displayRankGuitar = displayRankGuitar;
        this.displayRankBass = displayRankBass;
        this.displayRankBand = displayRankBand;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(int trackNum) {
        this.trackNum = trackNum;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public int getSortRankBass() {
        return sortRankBass;
    }

    public void setSortRankBass(int sortRankBass) {
        this.sortRankBass = sortRankBass;
    }

    public int getSortRankGuitar() {
        return sortRankGuitar;
    }

    public void setSortRankGuitar(int sortRankGuitar) {
        this.sortRankGuitar = sortRankGuitar;
    }

    public int getSortRankVocal() {
        return sortRankVocal;
    }

    public void setSortRankVocal(int sortRankVocal) {
        this.sortRankVocal = sortRankVocal;
    }

    public int getSortRankDrum() {
        return sortRankDrum;
    }

    public void setSortRankDrum(int sortRankDrum) {
        this.sortRankDrum = sortRankDrum;
    }

    public String getSortAlbum() {
        return sortAlbum;
    }

    public void setSortAlbum(String sortAlbum) {
        this.sortAlbum = sortAlbum;
    }

    public String getSortArtist() {
        return sortArtist;
    }

    public void setSortArtist(String sortArtist) {
        this.sortArtist = sortArtist;
    }

    public String getSortTitle() {
        return sortTitle;
    }

    public void setSortTitle(String sortTitle) {
        this.sortTitle = sortTitle;
    }

    public String getAwsArtworkLink() {
        return awsArtworkLink;
    }

    public void setAwsArtworkLink(String awsArtworkLink) {
        this.awsArtworkLink = awsArtworkLink;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getXboxStoreLink() {
        return xboxStoreLink;
    }

    public void setXboxStoreLink(String xboxStoreLink) {
        this.xboxStoreLink = xboxStoreLink;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public int getSortRankBand() {
        return sortRankBand;
    }

    public void setSortRankBand(int sortRankBand) {
        this.sortRankBand = sortRankBand;
    }

    public int getDisplayRankDrums() {
        return displayRankDrums;
    }

    public void setDisplayRankDrums(int displayRankDrums) {
        this.displayRankDrums = displayRankDrums;
    }

    public int getDisplayRankVocal() {
        return displayRankVocal;
    }

    public void setDisplayRankVocal(int displayRankVocal) {
        this.displayRankVocal = displayRankVocal;
    }

    public int getDisplayRankGuitar() {
        return displayRankGuitar;
    }

    public void setDisplayRankGuitar(int displayRankGuitar) {
        this.displayRankGuitar = displayRankGuitar;
    }

    public int getDisplayRankBass() {
        return displayRankBass;
    }

    public void setDisplayRankBass(int displayRankBass) {
        this.displayRankBass = displayRankBass;
    }

    public int getDisplayRankBand() {
        return displayRankBand;
    }

    public void setDisplayRankBand(int displayRankBand) {
        this.displayRankBand = displayRankBand;
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

    private String getDecade() {
        if (isBetween(year, 2020, 2029)) {
            return "2020s";
        } else if (isBetween(year, 2010, 2019)) {
            return "2010s";
        } else if (isBetween(year, 2000, 2009)) {
            return "2000s";
        } else if (isBetween(year, 1990, 1999)) {
            return "1990s";
        } else if (isBetween(year, 1980, 1989)) {
            return "1980s";
        } else if (isBetween(year, 1970, 1979)) {
            return "1970s";
        } else if (isBetween(year, 1960, 1969)) {
            return "1960s";
        } else if (isBetween(year, 1950, 1959)) {
            return "1950s";
        }

        return "Unknown";
    }

    public static boolean isBetween(final int x, final int lower, final int upper) {
        return lower <= x && x <= upper;
    }

    private String getStatus() {
        if (this.isOwned) {
            return "In Library";
        } else if (this.onWishlist) {
            return "On Wishlist";
        }
        return "Available For Purchase";
    }

    public String asTsvString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(artist + "\t");
        stringBuilder.append(title + "\t");
        stringBuilder.append(album + "\t");
        stringBuilder.append(genre + "\t");
        stringBuilder.append(year + "\t");
        stringBuilder.append(getDecade() + "\t");
        stringBuilder.append(releaseDate + "\t");
        stringBuilder.append(displayRankVocal + "\t");
        stringBuilder.append(displayRankGuitar + "\t");
        stringBuilder.append(displayRankBass + "\t");
        stringBuilder.append(displayRankDrums + "\t");
        stringBuilder.append(getStatus());
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bpm;
        result = prime * result + displayRankBand;
        result = prime * result + displayRankBass;
        result = prime * result + displayRankDrums;
        result = prime * result + displayRankGuitar;
        result = prime * result + displayRankVocal;
        result = prime * result + duration;
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((shortname == null) ? 0 : shortname.hashCode());
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
        if (bpm != other.bpm)
            return false;
        if (displayRankBand != other.displayRankBand)
            return false;
        if (displayRankBass != other.displayRankBass)
            return false;
        if (displayRankDrums != other.displayRankDrums)
            return false;
        if (displayRankGuitar != other.displayRankGuitar)
            return false;
        if (displayRankVocal != other.displayRankVocal)
            return false;
        if (duration != other.duration)
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (shortname == null) {
            if (other.shortname != null)
                return false;
        } else if (!shortname.equals(other.shortname))
            return false;
        return true;
    }
}
