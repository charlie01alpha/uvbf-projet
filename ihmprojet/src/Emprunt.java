import java.time.LocalDate;

public class Emprunt {
    private Livre livre;
    private Utilisateur utilisateur;
    private LocalDate dateEmprunt;
    private static final int DUREE_MAXIMALE = 14; // Durée maximale en jours

    public Emprunt(Livre livre, Utilisateur utilisateur) {
        this.livre = livre;
        this.utilisateur = utilisateur;
        this.dateEmprunt = LocalDate.now();
        livre.emprunter();
    }

    public Livre getLivre() {
        return livre;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public boolean estEnRetard() {
        return LocalDate.now().isAfter(dateEmprunt.plusDays(DUREE_MAXIMALE));
    }

    public long joursDeRetard() {
        if (estEnRetard()) {
            return LocalDate.now().toEpochDay() - dateEmprunt.plusDays(DUREE_MAXIMALE).toEpochDay();
        }
        return 0;
    }
}
