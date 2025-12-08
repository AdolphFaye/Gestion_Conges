module fr.ece.gestion_conge {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base; // Nécessaire pour les opérations de sécurité/hachage

    // OBLIGATOIRE 1 : Ouvrir le package racine pour la classe d'application principale
    opens fr.ece.gestion_conge to javafx.fxml, javafx.graphics;

    // OBLIGATOIRE 2 : Ouvrir le package 'controller' pour que le chargeur FXML trouve LoginController
    opens fr.ece.gestion_conge.controller to javafx.fxml;

    // OBLIGATOIRE 3 : Ouvrir le package 'model' pour le data binding (TableViews, etc.)
    opens fr.ece.gestion_conge.model to javafx.base;

    // Exporter le package racine et le DAO
    exports fr.ece.gestion_conge;
    exports fr.ece.gestion_conge.dao;
}