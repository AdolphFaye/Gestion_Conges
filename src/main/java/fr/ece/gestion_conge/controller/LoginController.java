package fr.ece.gestion_conge.controller;

import fr.ece.gestion_conge.dao.UserDAO;
import fr.ece.gestion_conge.model.Utilisateur;

import javafx.fxml.FXML;
import javafx.scene.control .*;




    public class LoginController {

        @FXML
        private TextField emailField;
        @FXML
        private PasswordField passwordField;
        @FXML
        private Label errorLabel;

        @FXML
        private void handleLogin() {

            String email = emailField.getText();
            String mdp = passwordField.getText();

            UserDAO userDAO = new UserDAO();
            Utilisateur user = userDAO.login(email, mdp);

            if (user != null) {
                errorLabel.setText("Connexion réussie !");
                // TODO : Redirection vers dashboard
            } else {
                errorLabel.setText("Identifiants incorrects");
            }
        }
    }


