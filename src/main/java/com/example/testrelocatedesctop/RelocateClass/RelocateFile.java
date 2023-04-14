package com.example.testrelocatedesctop.RelocateClass;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



public class RelocateFile {

    public static void identificationFile(File dir, ListView list) {
        if (dir.isDirectory()) {
            System.out.println(dir + "\t folder");
            list.getItems().addAll(dir.getName() + "\t folder");
        } else {
            System.out.println(dir + "\t file");
            list.getItems().addAll(dir.getName() + "\t folder");
        }
    }

    public static void listOfFilesInDir (File input, File output, ListView list) throws IOException {
        File[] files = input.listFiles(); // все выйлы содержащеся в дирректории записываются в массив
        assert files != null; // проверка на пустоту массива
        for (File value : files) {
            identificationFile(value, list);
            if (value.isDirectory()){
                createDir(value, output);
                listOfFilesInDir(value.getAbsoluteFile(), ostremDir, list);
            }
            if (!value.isDirectory())
                relocateFile(value, output);
        }
    }
    private static File ostremDir;
    public static void createDir (File is /*получаем имя файла*/, File os /*получаем путь*/) throws IOException {
        ostremDir = new File((os + "/" + is.getName())); // создаем по заданному пути файл
        ostremDir.mkdir();
    }
    private static File ostrem;
    public static void createFile (File is /*получаем имя файла*/, File os /*получаем путь*/) throws IOException {
        ostrem = new File((os + "/" + is.getName())); // создаем по заданному пути файл
        ostrem.createNewFile();
    }

    public static void relocateFile(File is, File os) throws IOException {
        createFile(is, os);

        try (FileInputStream fileInputStream = new FileInputStream(is);
             FileOutputStream fileOutputStream = new FileOutputStream(ostrem)) {
            byte[] buffer = new byte[1024];      // перемещаем каждый файл по байтам
            int length;
            while ((length = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
        }
    }
}
