module com.example.remidi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.remidi to javafx.fxml;
    exports com.example.remidi;
}