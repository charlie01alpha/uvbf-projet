// src/model/Bien.java
package model;

public class Bien {
    private String adresse;
    private double surface;
    private double prix;
    private String type; // maison, appartement, terrain
    private String disponibilite; // en vente, en location

    public Bien(String adresse, double surface, double prix, String type, String disponibilite) {
        this.adresse = adresse;
        this.surface = surface;
        this.prix = prix;
        this.type = type;
        this.disponibilite = disponibilite;
    }

    public String getAdresse() {
        return adresse;
    }

    public double getSurface() {
        return surface;
    }

    public double getPrix() {
        return prix;
    }

    public String getType() {
        return type;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    @Override
    public String toString() {
        return "Bien{" +
                "adresse='" + adresse + '\'' +
                ", surface=" + surface +
                ", prix=" + prix +
                ", type='" + type + '\'' +
                ", disponibilite='" + disponibilite + '\'' +
                '}';
    }
}
