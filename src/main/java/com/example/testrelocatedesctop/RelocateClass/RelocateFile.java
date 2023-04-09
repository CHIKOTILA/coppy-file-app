package com.example.testrelocatedesctop.RelocateClass;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



public class RelocateFile {

    public static void copyFileUsingStream(String sourceDirName, String targetSourceDir, ListView listFile) throws IOException {
        File folder = new File(sourceDirName);


        File[] listOfFiles = folder.listFiles();

        Path destDir = Paths.get(targetSourceDir);
        if (listOfFiles != null)
            for (File file : listOfFiles)
            {
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                if (file.isDirectory()) {
                    System.out.println(file.getName() + "\t folder");
                    listFile.getItems().addAll(file.getName() + "\t folder");
                } else {
                    System.out.println(file.getName() + "\t file");
                    listFile.getItems().addAll(file.getName() + "\t file");
                }
            }

    }
}
