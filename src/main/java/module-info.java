module com.example.oop2a4zms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.oop2a4zms to javafx.fxml;
    exports com.example.oop2a4zms;
    exports com.example.oop2a4zms.Controllers;
    opens com.example.oop2a4zms.Controllers to javafx.fxml;
    exports com.example.oop2a4zms.Model;
    opens com.example.oop2a4zms.Model to javafx.fxml;
}