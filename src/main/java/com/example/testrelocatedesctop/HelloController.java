package com.example.testrelocatedesctop;

import com.example.testrelocatedesctop.RelocateClass.RelocateFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.*;

public class HelloController {
    @FXML
    private TextField fromPathname;
    @FXML
    private TextField toPathname;
    @FXML
    private Label compliteLabel;
    @FXML
    public ListView list;
    @FXML
    protected void onRelocateButtonClick(ActionEvent event) throws IOException {
        String fromPath = fromPathname.getText();
                // "/Users/egorshapovalov/IdeaProjects/JavaActivate";

        String toPath = toPathname.getText();
                //"/Users/egorshapovalov/Downloads/testFolder";
        
        RelocateFile.copyFileUsingStream(toPath, fromPath, list);
        System.out.println("Complete");
        compliteLabel.setText("Complete");

    }
}