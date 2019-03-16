package com.vogella.android.projet_mobile.model;

import org.json.JSONArray;
import org.json.JSONObject;

public class RestCaracteristiqueResponse {

    private String nom;

    private int role;

    private int solo;

    private String lastup_h;

    private int id;

    private int classe;

    private String img;

    private String img_min;

    private JSONObject caracteristiques;

   /* private JSONArray talents1;

   private JSONArray autres;



    private JSONObject A;

    private JSONObject Z;

    private JSONObject E;

    private JSONObject D;


    private JSONArray talents4;

    private JSONArray talents7;

    private JSONArray talents10;

    private JSONArray talents13;

    private JSONArray talents16;

    private JSONArray talents20;*/

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

   public JSONObject getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(JSONObject caracteristiques) {
        this.caracteristiques = caracteristiques;
    }
    /*
    public JSONArray getTalents1() {
        return talents1;
    }

    public void setTalents1(JSONArray talents1) {
        this.talents1 = talents1;
    }

    public JSONObject getA() {
        return A;
    }

    public void setA(JSONObject a) {
        A = a;
    }

    public JSONObject getZ() {
        return Z;
    }

    public void setZ(JSONObject z) {
        Z = z;
    }

    public JSONObject getE() {
        return E;
    }

    public void setE(JSONObject e) {
        E = e;
    }

    public JSONObject getD() {
        return D;
    }

    public void setD(JSONObject d) {
        D = d;
    }



    public JSONArray getTalents4() {
        return talents4;
    }

    public void setTalents4(JSONArray talents4) {
        this.talents4 = talents4;
    }

    public JSONArray getTalents7() {
        return talents7;
    }

    public void setTalents7(JSONArray talents7) {
        this.talents7 = talents7;
    }

    public JSONArray getTalents10() {
        return talents10;
    }

    public void setTalents10(JSONArray talents10) {
        this.talents10 = talents10;
    }

    public JSONArray getTalents13() {
        return talents13;
    }

    public void setTalents13(JSONArray talents13) {
        this.talents13 = talents13;
    }

    public JSONArray getTalents16() {
        return talents16;
    }

    public void setTalents16(JSONArray talents16) {
        this.talents16 = talents16;
    }

    public JSONArray getTalents20() {
        return talents20;
    }

    public void setTalents20(JSONArray talents20) {
        this.talents20 = talents20;
    }

    public JSONArray getAutres() {
        return autres;
    }

    public void setAutres(JSONArray autres) {
        this.autres = autres;
    }
*/
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

}


