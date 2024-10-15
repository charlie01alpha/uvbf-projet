

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class VueAuthentification extends JFrame {
    private JTextField utilisateurField;
    private JPasswordField motDePasseField;
    private JButton loginButton;
    private GestionBibliotheque gestionBibliotheque;

    public VueAuthentification(GestionBibliotheque gestionBibliotheque) {
        this.gestionBibliotheque = gestionBibliotheque;

        setTitle("Authentification");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        utilisateurField = new JTextField(15);
        motDePasseField = new JPasswordField(15);
        loginButton = new JButton("Se connecter");

        add(new JLabel("Utilisateur:"));
        add(utilisateurField);
        add(new JLabel("Mot de passe:"));
        add(motDePasseField);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String utilisateur = utilisateurField.getText();
                String motDePasse = new String(motDePasseField.getPassword());

                if (gestionBibliotheque.authentifier(utilisateur, motDePasse)) {
                    JOptionPane.showMessageDialog(null, "Connexion réussie!");
                    // Ouvrir le tableau de bord ici
                } else {
                    JOptionPane.showMessageDialog(null, "Identifiants incorrects.");
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        GestionBibliotheque gestionBibliotheque = new GestionBibliotheque();
        new VueAuthentification(gestionBibliotheque);
    }
}
