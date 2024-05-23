package com.mirea.kt.practical2_10;


public class Plant {
    private int id;
    private String name;
    private String species;
    private boolean isGreenhouse;


    public Plant() {}


    public Plant(String name, String species, boolean isGreenhouse) {
        this.name = name;
        this.species = species;
        this.isGreenhouse = isGreenhouse;
    }


    public Plant(int id, String name, String species, boolean isGreenhouse) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.isGreenhouse = isGreenhouse;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isGreenhouse() {
        return isGreenhouse;
    }

    public void setGreenhouse(boolean greenhouse) {
        isGreenhouse = greenhouse;
    }
}
