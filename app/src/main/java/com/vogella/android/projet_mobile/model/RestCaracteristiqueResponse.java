package com.vogella.android.projet_mobile.model;

import org.json.JSONArray;

import java.util.List;

public class RestCaracteristiqueResponse {

    private String nom;

    private int role;

    private int solo;

    private String lastup_h;

    private int id;

    private int classe;

    private String img;

    private String img_min;

    private Caracteristiques caracteristiques;

    private Spell A;

    private Spell Z;

    private Spell E;

    private Spell D;

    private List<Talent> talents1;

    private List<Talent> talents4;

    private List<Talent> talents7;

    private List<Talent> talents10;

    private List<Talent> talents13;

    private List<Talent> talents16;

    private List<Talent> talents20;

    private String guide;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg_min() {
        return img_min;
    }

    public void setImg_min(String img_min) {
        this.img_min = img_min;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   public Caracteristiques getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(Caracteristiques caracteristiques) {
        this.caracteristiques = caracteristiques;
    }


    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getSolo() {
        return solo;
    }

    public void setSolo(int solo) {
        this.solo = solo;
    }

    public String getLastup_h() {
        return lastup_h;
    }

    public void setLastup_h(String lastup_h) {
        this.lastup_h = lastup_h;
    }

    public Spell getA() {
        return A;
    }

    public void setA(Spell a) {
        A = a;
    }

    public Spell getZ() {
        return Z;
    }

    public void setZ(Spell z) {
        Z = z;
    }

    public Spell getE() {
        return E;
    }

    public void setE(Spell e) {
        E = e;
    }

    public Spell getD() {
        return D;
    }

    public void setD(Spell d) {
        D = d;
    }

    public List<Talent> getTalents1() {
        return talents1;
    }

    public void setTalents1(List<Talent> talents1) {
        this.talents1 = talents1;
    }

    public List<Talent> getTalents4() {
        return talents4;
    }

    public void setTalents4(List<Talent> talents4) {
        this.talents4 = talents4;
    }

    public List<Talent> getTalents7() {
        return talents7;
    }

    public void setTalents7(List<Talent> talents7) {
        this.talents7 = talents7;
    }

    public List<Talent> getTalents10() {
        return talents10;
    }

    public void setTalents10(List<Talent> talents10) {
        this.talents10 = talents10;
    }

    public List<Talent> getTalents13() {
        return talents13;
    }

    public void setTalents13(List<Talent> talents13) {
        this.talents13 = talents13;
    }

    public List<Talent> getTalents16() {
        return talents16;
    }

    public void setTalents16(List<Talent> talents16) {
        this.talents16 = talents16;
    }

    public List<Talent> getTalents20() {
        return talents20;
    }

    public void setTalents20(List<Talent> talents20) {
        this.talents20 = talents20;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}


