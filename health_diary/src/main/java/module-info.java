module com.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.app to javafx.fxml;
    exports com.app;

    exports com.app.view;
    exports com.app.controller;
}
