package fr.ece.gestion_conge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBUtil {

        // Informations de connexion MySQL (basées sur votre schéma)
        private static final String URL = "jdbc:mysql://localhost:3306/gestion_conges";
        private static final String USER = "root"; // Votre utilisateur MySQL
        private static final String PASSWORD = ""; // Votre mot de passe MySQL (laissez vide si non défini)

        // Bloc statique pour charger le driver JDBC une seule fois
        static {
            try {
                // Chargement explicite du pilote MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println("Erreur fatale : Le pilote MySQL JDBC est introuvable. " +
                        "Vérifiez si le fichier JAR du connecteur est bien dans votre pom.xml.");
                // Lance une exception critique si l'application ne peut pas se connecter
                throw new RuntimeException("Pilote MySQL manquant.", e);
            }
        }

        /**
         * Crée et retourne une NOUVELLE connexion à la base de données.
         * Cette connexion doit être fermée par l'appelant (via try-with-resources).
         * @return Nouvelle instance de Connection
         * @throws SQLException si la connexion échoue (mauvaise URL, identifiants incorrects, DB non démarrée)
         */
        public static Connection getConnection() throws SQLException {
            // Crée une nouvelle connexion
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        /**
         * Méthode optionnelle pour fermer une connexion (souvent remplacée par try-with-resources).
         * @param conn la connexion à fermer
         */
        public static void closeConnection(Connection conn) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la tentative de fermeture de la connexion: " + e.getMessage());
                }
            }
        }
    }

