// src/model/Transaction.java
package model;

public class Transaction {
    private Bien bien;
    private Client client;
    private double montant; // Pour les achats
    private int duree; // Pour les locations

    public Transaction(Bien bien, Client client, double montant) {
        this.bien = bien;
        this.client = client;
        this.montant = montant;
    }

    public Transaction(Bien bien, Client client, int duree) {
        this.bien = bien;
        this.client = client;
        this.duree = duree;
    }

    @Override
    public String toString() {
        if (montant != 0) {
            return "Transaction{" +
                    "bien=" + bien +
                    ", client=" + client +
                    ", montant=" + montant +
                    '}';
        } else {
            return "Transaction{" +
                    "bien=" + bien +
                    ", client=" + client +
                    ", duree=" + duree + " mois" +
                    '}';
        }
    }
}
