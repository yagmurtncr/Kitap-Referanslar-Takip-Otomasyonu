module com.example.otomasyon2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.otomasyon2 to javafx.fxml;
    exports com.example.otomasyon2;
}