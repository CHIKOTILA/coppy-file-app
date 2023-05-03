package com.example.testrelocatedesctop.RelocateClass;
import javafx.scene.control.ListView;

import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class ListAPFSDescriptions {
    public static void listDescriptors(String path, ListView listView) {
        try {
            // Создаем объект Path для корневой директории APFS
            Path apfsRoot = Paths.get("/Users/egorshapovalov/Downloads/testFolder");

            // Получаем поток всех файлов и директорий в корневой директории APFS
            Stream<Path> files = Files.list(apfsRoot);

            // Выводим дескрипторы каждого файла и директории
            files.forEach(file -> {
                try {
                    System.out.println(file.toRealPath() + " -- " + Files.getAttribute(file, "unix:ino"));
                    listView.getItems().addAll(file.toRealPath() + " -- " + Files.getAttribute(file, "unix:ino"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
