package fr.ece.application_conge;

import dao.UserDAO;
import model.Utilisateur;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() {
        System.out.println("=== Bouton Connecter cliqué ===");

        String email = emailField.getText();
        String mdp = passwordField.getText();

        System.out.println("Email saisi: " + email);
        System.out.println("Mot de passe saisi: " + (mdp.isEmpty() ? "[vide]" : "[*****]"));

        if (email.isEmpty() || mdp.isEmpty()) {
            errorLabel.setText("Veuillez remplir tous les champs.");
            errorLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        try {
            UserDAO userDAO = new UserDAO();
            System.out.println("UserDAO créé, appel de login()...");

            Utilisateur user = userDAO.login(email, mdp);
            System.out.println("Résultat login: " + (user != null ? "Utilisateur trouvé" : "null"));

            if (user != null) {
                errorLabel.setText("Connexion réussie ! Bienvenue " + user.getPrenom());
                errorLabel.setStyle("-fx-text-fill: green;");
                System.out.println("Connexion réussie pour: " + user.getNom() + " " + user.getPrenom());
            } else {
                errorLabel.setText("Email ou mot de passe incorrect.");
                errorLabel.setStyle("-fx-text-fill: red;");
                System.out.println("Échec de connexion: identifiants incorrects");
            }
        } catch (Exception e) {
            errorLabel.setText("Erreur de connexion: " + e.getMessage());
            errorLabel.setStyle("-fx-text-fill: red;");
            System.err.println("Exception lors de la connexion:");
            e.printStackTrace();
        }
    }
}