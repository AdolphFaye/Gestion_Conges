module fr.ece.application_conge {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens fr.ece.application_conge to javafx.fxml;
    opens model to javafx.base;

    exports fr.ece.application_conge;
    exports model;
    exports dao;
}
