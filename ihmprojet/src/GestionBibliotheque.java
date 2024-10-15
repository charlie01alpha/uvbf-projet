
import java.util.*;

public class GestionBibliotheque {
    private Map<String, Utilisateur> utilisateurs;
    private List<Livre> livres;
    private List<Emprunt> emprunts;

    public GestionBibliotheque() {
        utilisateurs = new HashMap<>();
        livres = new ArrayList<>();
        emprunts = new ArrayList<>();
        // Ajout d'exemple d'utilisateurs et de livres
        utilisateurs.put("admin", new Utilisateur("admin", "1234", "bibliothecaire"));
        utilisateurs.put("etudiant1", new Utilisateur("etudiant1", "abcd", "etudiant"));
    }

    public boolean authentifier(String nom, String motDePasse) {
        Utilisateur utilisateur = utilisateurs.get(nom);
        if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {
            return true;
        }
        return false;
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public void emprunterLivre(Utilisateur utilisateur, Livre livre) {
        if (livre.estDisponible()) {
            Emprunt emprunt = new Emprunt(livre, utilisateur);
            emprunts.add(emprunt);
        } else {
            System.out.println("Le livre est déjà emprunté.");
        }
    }

    public void retournerLivre(Emprunt emprunt) {
        emprunt.getLivre().retourner();
        emprunts.remove(emprunt);
    }

    public List<Livre> rechercherLivre(String critere, String valeur) {
        List<Livre> result = new ArrayList<>();
        for (Livre livre : livres) {
            if (critere.equals("titre") && livre.getTitre().contains(valeur)) {
                result.add(livre);
            } else if (critere.equals("auteur") && livre.getAuteur().contains(valeur)) {
                result.add(livre);
            }
        }
        return result;
    }
}

