
import java.time.LocalDate;

public class Livre {
    private String titre;
    private String auteur;
    private int anneePublication;
    private boolean disponible;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    public Livre(String titre, String auteur, int anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.disponible = true;
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public boolean estDisponible() {
        return disponible;
    }

    public void emprunter() {
        this.disponible = false;
        this.dateEmprunt = LocalDate.now();
        this.dateRetour = dateEmprunt.plusDays(14);  // Durée maximale de 14 jours
    }

    public void retourner() {
        this.disponible = true;
        this.dateEmprunt = null;
        this.dateRetour = null;
    }
}
