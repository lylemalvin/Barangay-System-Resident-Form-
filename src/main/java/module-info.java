module com.sanmarino.barangaysystem {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sanmarino.barangaysystem to javafx.fxml;
    exports com.sanmarino.barangaysystem;
}