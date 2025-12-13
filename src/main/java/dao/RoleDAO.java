package dao;

import model.Role;
import java.sql.*;

// Cette classe est essentielle pour que UserDAO puisse récupérer l'objet Role
public class RoleDAO {

    public Role getRoleById(int idRole) throws SQLException {
        // Logique de requête SQL basée sur la table `role` de votre schéma DB
        String sql = "SELECT ID_Role, Nom_Role FROM role WHERE ID_Role = ?";

        // Utilisation de DBUtil (qui doit avoir été renommé)
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idRole);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Role(rs.getInt("ID_Role"), rs.getString("Nom_Role"));
                }
            }
        } // Les ressources se ferment automatiquement

        // Si aucun rôle n'est trouvé, cela peut lancer une exception ou retourner un rôle par défaut
        return new Role(0, "Rôle non défini");
    }
}