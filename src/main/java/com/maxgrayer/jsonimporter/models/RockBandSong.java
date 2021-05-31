package com.maxgrayer.jsonimporter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RockBandSong {

    private String f1;
    private String f2;
    private int f3;
    private String f4;
    private int f5;
    private String f6;
    private boolean f7;
    private String f8;
    private int f9;
    private String f45;
    private String f44;
    private int f47;
    private int f46;
    private int f49;
    private int f48;
    private boolean f23;
    private String f22;
    private String f21;
    private String f20;
    private String f27;
    private String[] f26;
    private String f25;
    private String f24;
    private boolean f29;
    private String f28;
    private int f52;
    private int f51;
    private int f50;
    private boolean f30;
    private boolean f31;
    private int f18;
    private boolean f19;
    private boolean f34;
    private boolean f35;
    private int f12;
    private int f13;
    private int f10;
    private int f11;
    private int f16;
    private int f17;
    private int f14;
    private int f15;

    @JsonProperty("f1")
    public String title() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    @JsonProperty("f2")
    public String artist() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    @JsonProperty("f3")
    public int year() {
        return f3;
    }

    public void setF3(int f3) {
        this.f3 = f3;
    }

    @JsonProperty("f4")
    public String album() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

    @JsonProperty("f5")
    public int trackNum() {
        return f5;
    }

    public void setF5(int f5) {
        this.f5 = f5;
    }

    @JsonProperty("f6")
    public String genre() {
        return f6;
    }

    public void setF6(String f6) {
        this.f6 = f6;
    }

    @JsonProperty("f7")
    public boolean isF7() {
        return f7;
    }

    public void setF7(boolean f7) {
        this.f7 = f7;
    }

    @JsonProperty("f8")
    public String gender() {
        return f8;
    }

    public void setF8(String f8) {
        this.f8 = f8;
    }

    @JsonProperty("f9")
    public int duration() {
        return f9;
    }

    public void setF9(int f9) {
        this.f9 = f9;
    }

    @JsonProperty("f45")
    public String shortname() {
        return f45;
    }

    public void setF45(String f45) {
        this.f45 = f45;
    }

    @JsonProperty("f44")
    public String id() {
        return f44;
    }

    public void setF44(String f44) {
        this.f44 = f44;
    }

    @JsonProperty("f47")
    public int sortRankBass() {
        return f47;
    }

    public void setF47(int f47) {
        this.f47 = f47;
    }

    @JsonProperty("f46")
    public int sortRankGuitar() {
        return f46;
    }

    public void setF46(int f46) {
        this.f46 = f46;
    }

    @JsonProperty("f49")
    public int sortRankVocal() {
        return f49;
    }

    public void setF49(int f49) {
        this.f49 = f49;
    }

    @JsonProperty("f48")
    public int sortRankDrum() {
        return f48;
    }

    public void setF48(int f48) {
        this.f48 = f48;
    }

    @JsonProperty("f23")
    public boolean isF23() {
        return f23;
    }

    public void setF23(boolean f23) {
        this.f23 = f23;
    }

    @JsonProperty("f22")
    public String sortAlbum() {
        return f22;
    }

    public void setF22(String f22) {
        this.f22 = f22;
    }

    @JsonProperty("f21")
    public String sortArtist() {
        return f21;
    }

    public void setF21(String f21) {
        this.f21 = f21;
    }

    @JsonProperty("f20")
    public String sortTitle() {
        return f20;
    }

    public void setF20(String f20) {
        this.f20 = f20;
    }

    @JsonProperty("f27")
    public String awsArtworkLink() {
        return f27;
    }

    public void setF27(String f27) {
        this.f27 = f27;
    }

    @JsonProperty("f26")
    public String[] sources() {
        return f26;
    }

    public void setF26(String[] f26) {
        this.f26 = f26;
    }

    @JsonProperty("f25")
    public String unknownDate() {
        return f25;
    }

    public void setF25(String f25) {
        this.f25 = f25;
    }

    @JsonProperty("f24")
    public String releaseDate() {
        return f24;
    }

    public void setF24(String f24) {
        this.f24 = f24;
    }

    @JsonProperty("f29")
    public boolean isF29() {
        return f29;
    }

    public void setF29(boolean f29) {
        this.f29 = f29;
    }

    @JsonProperty("f28")
    public String xboxStoreLink() {
        return f28;
    }

    public void setF28(String f28) {
        this.f28 = f28;
    }

    @JsonProperty("f52")
    public int getF52() {
        return f52;
    }

    public void setF52(int f52) {
        this.f52 = f52;
    }

    @JsonProperty("f51")
    public int bpm() {
        return f51;
    }

    public void setF51(int f51) {
        this.f51 = f51;
    }

    @JsonProperty("f50")
    public int sortRankBand() {
        return f50;
    }

    public void setF50(int f50) {
        this.f50 = f50;
    }

    @JsonProperty("f30")
    public boolean isF30() {
        return f30;
    }

    public void setF30(boolean f30) {
        this.f30 = f30;
    }

    @JsonProperty("f31")
    public boolean isF31() {
        return f31;
    }

    public void setF31(boolean f31) {
        this.f31 = f31;
    }

    @JsonProperty("f18")
    public int getF18() {
        return f18;
    }

    public void setF18(int f18) {
        this.f18 = f18;
    }

    @JsonProperty("f19")
    public boolean isF19() {
        return f19;
    }

    public void setF19(boolean f19) {
        this.f19 = f19;
    }

    @JsonProperty("f34")
    public boolean isF34() {
        return f34;
    }

    public void setF34(boolean f34) {
        this.f34 = f34;
    }

    @JsonProperty("f35")
    public boolean isF35() {
        return f35;
    }

    public void setF35(boolean f35) {
        this.f35 = f35;
    }

    @JsonProperty("f12")
    public int displayRankDrums() {
        return f12;
    }

    public void setF12(int f12) {
        this.f12 = f12;
    }

    @JsonProperty("f13")
    public int displayRankVocal() {
        return f13;
    }

    public void setF13(int f13) {
        this.f13 = f13;
    }

    @JsonProperty("f10")
    public int displayRankGuitar() {
        return f10;
    }

    public void setF10(int f10) {
        this.f10 = f10;
    }

    @JsonProperty("f11")
    public int displayRankBass() {
        return f11;
    }

    public void setF11(int f11) {
        this.f11 = f11;
    }

    @JsonProperty("f16")
    public int getF16() {
        return f16;
    }

    public void setF16(int f16) {
        this.f16 = f16;
    }

    @JsonProperty("f17")
    public int getF17() {
        return f17;
    }

    public void setF17(int f17) {
        this.f17 = f17;
    }

    @JsonProperty("f14")
    public int displayRankBand() {
        return f14;
    }

    public void setF14(int f14) {
        this.f14 = f14;
    }

    @JsonProperty("f15")
    public int getF15() {
        return f15;
    }

    public void setF15(int f15) {
        this.f15 = f15;
    }

}
