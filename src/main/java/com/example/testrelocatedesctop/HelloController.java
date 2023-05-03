package com.example.testrelocatedesctop;

import com.example.testrelocatedesctop.RelocateClass.ListAPFSDescriptions;
import com.example.testrelocatedesctop.RelocateClass.RelocateFile;
import com.example.testrelocatedesctop.RelocateClass.WindowDescriptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;

public class HelloController {

    @FXML
    public Button click;
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
        //"/Users/egorshapovalov/Downloads/TestFolder2"
        //"/Users/egorshapovalov/Downloads/testFolder"
        // сделать чтобы лист был во все окно
        File fileOutput = new File(toPathname.getText());
        File fileInput = new File(fromPathname.getText());
        RelocateFile.listOfFilesInDir(fileInput, fileOutput, list);
        System.out.println("Complete");
        compliteLabel.setText("Complete");

    }

    public void showDescriptions(ActionEvent event) {
        try {
            WindowDescriptions.openWindowDescriptions(toPathname.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}