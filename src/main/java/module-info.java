module com.example.testrelocatedesctop {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.testrelocatedesctop to javafx.fxml;
    exports com.example.testrelocatedesctop;
}