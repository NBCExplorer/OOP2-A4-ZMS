module com.example.oop2a4zms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop2a4zms to javafx.fxml;
    exports com.example.oop2a4zms;
}