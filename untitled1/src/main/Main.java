// src/main/Main.java
package main;

import service.GestionImmobilier;

public class Main {
    public static void main(String[] args) {
        // Créer une instance de GestionImmobilier
        GestionImmobilier gestion = new GestionImmobilier();

        // Afficher le menu pour interagir avec l'utilisateur
        gestion.afficherMenu();
    }
}
