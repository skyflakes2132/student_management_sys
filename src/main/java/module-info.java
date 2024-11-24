module com.example.bwiset {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    


    opens com.example.bwiset to javafx.fxml;
    exports com.example.bwiset;
}