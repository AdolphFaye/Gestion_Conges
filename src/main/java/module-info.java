module fr.ece.gestion_conge {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires java.desktop;


    // <<< OBLIGATOIRE POUR UTILISER JDBC

    opens fr.ece.gestion_conge to javafx.fxml;
}