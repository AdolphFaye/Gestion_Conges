package fr.ece.gestion_conge.dao;

// Importation des modèles depuis le bon package
import fr.ece.gestion_conge.model.Role;
import fr.ece.gestion_conge.model.Utilisateur;
import java.sql.*;

public class UserDAO {

    public Utilisateur login(String email, String mdp) {
        Utilisateur user = null;

        // Requête SQL utilisant les noms de colonnes de votre schéma (Email et Mot_De_Passe)
        String sql = "SELECT * FROM utilisateur WHERE Email=? AND Mot_De_Passe=?";

        // Utilisation de try-with-resources pour la fermeture automatique des ressources (conn, ps, rs).
        // Cela résout l'erreur 'Incompatible types' et la dépendance à DBUtil.
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, email);

            // ATTENTION: Le Cahier des Charges exige le hachage des mots de passe pour la sécurité.
            // Vous devriez hacher 'mdp' ici avant de l'envoyer à la DB.
            ps.setString(2, mdp);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new Utilisateur();

                    // Remplissage de l'objet Utilisateur avec les noms de colonnes SQL corrects
                    user.setIdUser(rs.getInt("ID_User"));
                    user.setNom(rs.getString("Nom"));
                    user.setPrenom(rs.getString("Prenom"));
                    user.setEmail(rs.getString("Email"));

                    // NOTE IMPORTANTE : Le solde n'est pas dans la table 'utilisateur' (il est dans 'solde_conge').
                    // Vous devrez faire une requête séparée pour obtenir le solde.
                    // user.setSoldeConge(rs.getDouble("soldeConge"));

                    // Récupérer le rôle (nécessite que RoleDAO soit créé et fonctionne)
                    RoleDAO roleDAO = new RoleDAO();
                    Role role = roleDAO.getRoleById(rs.getInt("ID_Role")); // Colonne FK ID_Role
                    user.setRole(role);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors du login: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Ajoutez ici d'autres méthodes CRUD (save, update, delete, findById, etc.)
}