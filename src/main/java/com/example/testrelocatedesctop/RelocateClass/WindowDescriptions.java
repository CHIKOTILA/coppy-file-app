package com.example.testrelocatedesctop.RelocateClass;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class WindowDescriptions {
    @FXML
    public static void openWindowDescriptions(String path) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();
        ListView listView = new ListView();
        listView.setPrefSize(526, 329);
        ListAPFSDescriptions.listDescriptors(path, listView);
        pane.getChildren().addAll(listView);
        Scene scene = new Scene(pane, 526, 329);
        stage.setTitle("Descriptions");
        stage.setScene(scene);
        stage.showAndWait();
    }
}
