package com.vogella.android.projet_mobile.model;

import java.util.HashMap;
import java.util.List;

public class RestCaracteristiqueMapResponse {

    private int id;
    private String nom;
    private List<Integer> synergies;
    private String image;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getSynergies() {
        return synergies;
    }

    public void setSynergies(List<Integer> synergies) {
        this.synergies = synergies;
    }
}
