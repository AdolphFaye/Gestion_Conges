package fr.ece.gestion_conge.model;

public class conge {


 // Non utilisé pour l'instant, mais peut servir pour Date_Entree
// La classe Role n'a pas besoin d'être importée car elle est dans le même package model

    public class Utilisateur {
        private int idUser; // ID user (ID_User dans SQL)
        private String nom;
        private String prenom;
        private String email;
        private String motDePasse; // Mot_De_Passe (dans SQL)
        private double soldeConge;
        private Role role;

        // Constructeur vide (Obligatoire pour l'instanciation dans UserDAO: user = new Utilisateur())
        public Utilisateur() {}

        // --- Getters et Setters (Corrige les erreurs de méthode manquante) ---

        public int getIdUser() { return idUser; }
        public void setIdUser(int idUser) { this.idUser = idUser; }

        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; } // Requis par UserDAO

        public String getPrenom() { return prenom; }
        public void setPrenom(String prenom) { this.prenom = prenom; } // Requis par UserDAO

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; } // Requis par UserDAO

        public double getSoldeConge() { return soldeConge; }
        public void setSoldeConge(double soldeConge) { this.soldeConge = soldeConge; } // Requis par UserDAO

        public Role getRole() { return role; }
        public void setRole(Role role) { this.role = role; } // Requis par UserDAO

        // Ajoutez d'autres méthodes ou attributs nécessaires (manager, dateEntree, etc.)
    }
}
