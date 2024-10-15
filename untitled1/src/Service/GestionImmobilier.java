// src/service/GestionImmobilier.java
package service;

import model.Bien;
import model.Client;
import model.Transaction;
import model.Visite;
import model.Client.Acheteur;
import model.Client.Locataire;
import model.Client.Vendeur;

import java.util.*;

public class GestionImmobilier {
    private List<Bien> biens = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Visite> visites = new ArrayList<>();

    // Méthode pour afficher le menu
    public void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Ajouter un bien");
            System.out.println("2. Ajouter un client");
            System.out.println("3. Rechercher un bien");
            System.out.println("4. Effectuer une transaction");
            System.out.println("5. Planifier une visite");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choix) {
                case 1:
                    ajouterBien(scanner);
                    break;
                case 2:
                    ajouterClient(scanner);
                    break;
                case 3:
                    rechercherBien(scanner);
                    break;
                case 4:
                    effectuerTransaction(scanner);
                    break;
                case 5:
                    planifierVisite(scanner);
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    return;
            }
        }
    }

    // Méthodes pour ajouter des biens, des clients, rechercher des biens, effectuer des transactions, planifier des visites
    private void ajouterBien(Scanner scanner) {
        System.out.print("Entrez l'adresse du bien : ");
        String adresse = scanner.nextLine();
        System.out.print("Entrez la surface du bien (en m²) : ");
        double surface = scanner.nextDouble();
        System.out.print("Entrez le prix du bien : ");
        double prix = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Entrez le type de bien (maison, appartement, terrain) : ");
        String type = scanner.nextLine();
        System.out.print("Entrez la disponibilité du bien (en vente, en location) : ");
        String disponibilite = scanner.nextLine();

        Bien bien = new Bien(adresse, surface, prix, type, disponibilite);
        biens.add(bien);
        System.out.println("Bien ajouté : " + bien);
    }

    private void ajouterClient(Scanner scanner) {
        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le contact du client : ");
        String contact = scanner.nextLine();
        System.out.print("Choisissez le type de client (1: Acheteur, 2: Locataire, 3: Vendeur) : ");
        int choixClient = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Client client = null;
        switch (choixClient) {
            case 1:
                System.out.print("Entrez le budget de l'acheteur : ");
                double budget = scanner.nextDouble();
                client = new Client.Acheteur(nom, contact, budget);
                break;
            case 2:
                System.out.print("Entrez le budget mensuel du locataire : ");
                double budgetMensuel = scanner.nextDouble();
                client = new Client.Locataire(nom, contact, budgetMensuel);
                break;
            case 3:
                System.out.print("Entrez le prix souhaité pour la vente : ");
                double prixSouhaite = scanner.nextDouble();
                client = new Client.Vendeur(nom, contact, prixSouhaite);
                break;
            default:
                System.out.println("Choix invalide.");
                return;
        }
        clients.add(client);
        System.out.println("Client ajouté : " + client);
    }

    private void rechercherBien(Scanner scanner) {
        System.out.println("=== Recherche de bien ===");
        System.out.print("Entrez un prix maximum : ");
        double prixMax = scanner.nextDouble();
        System.out.print("Entrez une surface minimum : ");
        double surfaceMin = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        for (Bien bien : biens) {
            if (bien.getPrix() <= prixMax && bien.getSurface() >= surfaceMin) {
                System.out.println(bien);
            }
        }
    }

    private void effectuerTransaction(Scanner scanner) {
        System.out.println("=== Effectuer une transaction ===");
        System.out.print("Choisissez le type de transaction (1: Achat, 2: Location) : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Entrez l'ID du bien : ");
        int bienId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Bien bien = biens.get(bienId); // Assurez-vous que bienId est valide

        System.out.print("Entrez l'ID du client : ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Client client = clients.get(clientId); // Assurez-vous que clientId est valide

        Transaction transaction = null;
        if (choix == 1) {
            System.out.print("Entrez le montant de l'achat : ");
            double montant = scanner.nextDouble();
            transaction = new Transaction(bien, client, montant);
        } else if (choix == 2) {
            System.out.print("Entrez la durée de la location (en mois) : ");
            int duree = scanner.nextInt();
            transaction = new Transaction(bien, client, duree);
        }

        transactions.add(transaction);
        System.out.println("Transaction enregistrée : " + transaction);
    }

    private void planifierVisite(Scanner scanner) {
        System.out.println("=== Planifier une visite ===");
        System.out.print("Entrez l'ID du bien à visiter : ");
        int bienId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Bien bien = biens.get(bienId); // Assurez-vous que bienId est valide

        System.out.print("Entrez la date de la visite (jj/mm/aaaa) : ");
        String dateStr = scanner.nextLine();
        Date dateVisite = new Date(dateStr); // Vous pouvez améliorer la gestion des dates

        List<Client> clientsInteressés = new ArrayList<>();
        System.out.println("Entrez les clients intéressés (ID client, entrez -1 pour arrêter) : ");
        while (true) {
            int clientId = scanner.nextInt();
            if (clientId == -1) break;
            clientsInteressés.add(clients.get(clientId)); // Assurez-vous que clientId est valide
        }

        Visite visite = new Visite(dateVisite, bien, clientsInteressés);
        visites.add(visite);
        System.out.println("Visite planifiée : " + visite);
    }
}
