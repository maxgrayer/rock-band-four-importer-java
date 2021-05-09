package com.maxgrayer.jsonimporter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Genre {
    private int id;
    private boolean active;
    private String name;
    private String updated;

    public void id(final int id) {
        this.id = id;
    }

    @JsonProperty("id")
    public int id() {
        return id;
    }

    public void active(final boolean active) {
        this.active = active;
    }

    @JsonProperty("active")
    public boolean active() {
        return active;
    }

    public void name(final String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String name() {
        return name;
    }

    public void updated(final String updated) {
        this.updated = updated;
    }

    @JsonProperty("updated")
    public String updated() {
        return updated;
    }
}
