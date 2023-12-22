package com.example.find_res.model;

public class Magasin {
    private String ville,adresse,name;
    private int tel;

    public Magasin(String ville, String adresse, String name, int tel) {
        this.ville = ville;
        this.adresse = adresse;
        this.name = name;
        this.tel = tel;
    }

    public String getVille() {
        return ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getName() {
        return name;
    }

    public int getTel() {
        return tel;
    }
}
