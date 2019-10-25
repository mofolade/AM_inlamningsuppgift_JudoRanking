package com.company;

/**
 * Country object with ISO code (3 letters) and country name.
 */
public class Country {

    private String iso;
    private String name;

    public Country(String iso, String name) {
        this.iso = iso;
        this.name = name;
    }

    public String getIso() {
        return iso;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return iso + " - " + name + " | ";
    }

}