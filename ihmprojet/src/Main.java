public class Main {
    public static void main(String[] args) {
        // Création de la gestion de la bibliothèque
        GestionBibliotheque gestionBibliotheque = new GestionBibliotheque();

        // Lancer l'interface d'authentification
        new VueAuthentification(gestionBibliotheque);
    }
}
