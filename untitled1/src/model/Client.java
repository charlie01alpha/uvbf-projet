// src/model/Client.java
package model;

public abstract class Client {
    protected String nom;
    protected String contact;

    public Client(String nom, String contact) {
        this.nom = nom;
        this.contact = contact;
    }

    public String getNom() {
        return nom;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    // Sous-classes représentant les types spécifiques de clients
    public static class Acheteur extends Client {
        private double budget;

        public Acheteur(String nom, String contact, double budget) {
            super(nom, contact);
            this.budget = budget;
        }

        public double getBudget() {
            return budget;
        }

        @Override
        public String toString() {
            return super.toString() + ", Acheteur{" +
                    "budget=" + budget +
                    '}';
        }
    }

    public static class Locataire extends Client {
        private double budgetMensuel;

        public Locataire(String nom, String contact, double budgetMensuel) {
            super(nom, contact);
            this.budgetMensuel = budgetMensuel;
        }

        public double getBudgetMensuel() {
            return budgetMensuel;
        }

        @Override
        public String toString() {
            return super.toString() + ", Locataire{" +
                    "budgetMensuel=" + budgetMensuel +
                    '}';
        }
    }

    public static class Vendeur extends Client {
        private double prixSouhaite;

        public Vendeur(String nom, String contact, double prixSouhaite) {
            super(nom, contact);
            this.prixSouhaite = prixSouhaite;
        }

        public double getPrixSouhaite() {
            return prixSouhaite;
        }

        @Override
        public String toString() {
            return super.toString() + ", Vendeur{" +
                    "prixSouhaite=" + prixSouhaite +
                    '}';
        }
    }
}
