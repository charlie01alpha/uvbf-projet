public class Utilisateur {
    private String nom;
    private String motDePasse;
    private String type; // "bibliothecaire" ou "etudiant"

    public Utilisateur(String nom, String motDePasse, String type) {
        this.nom = nom;
        this.motDePasse = motDePasse;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getType() {
        return type;
    }
}
