package model;




// Nécessite l'import de la classe Role
import model.Role;


    public class Utilisateur {
        private int idUser;
        private String nom;
        private String prenom;
        private String email;
        private double soldeConge;
        private Role role;

        public Utilisateur() {
        }

        // --- Setters (Répondent aux erreurs 'Cannot resolve method') ---
        public void setIdUser(int idUser) {
            this.idUser = idUser;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setSoldeConge(double soldeConge) {
            this.soldeConge = soldeConge;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        // --- Getters (Indispensables pour utiliser l'objet) ---
        public int getIdUser() {
            return idUser;
        }

        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public String getEmail() {
            return email;
        }

        public Role getRole() {
            return role;
        }

        public String getMotDePasse() {
            return null;
        } // À ajouter si nécessaire
    }

