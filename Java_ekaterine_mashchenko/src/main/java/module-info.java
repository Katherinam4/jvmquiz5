module com.example.java_ekaterine_mashchenko {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.java_ekaterine_mashchenko to javafx.fxml;
    exports com.example.java_ekaterine_mashchenko;
}