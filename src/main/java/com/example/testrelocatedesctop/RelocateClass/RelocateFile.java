package com.example.testrelocatedesctop.RelocateClass;

import javafx.scene.control.ListView;
import java.io.*;


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

    public static void listOfFilesInDir(File inputStream, File outputStream, ListView list) throws IOException {
        File[] files = inputStream.listFiles(); // все выйлы содержащеся в дирректории записываются в массив
        assert files != null; // проверка на пустоту массива
        for (File value : files) {
            identificationFile(value, list);
            if (value.isDirectory()) {
                createDir(value, outputStream);
                listOfFilesInDir(value.getAbsoluteFile(), osStreamDir, list); // рекурсивный вызов функции
            }
            if (!value.isDirectory())
                relocateFile(value, outputStream);
        }
    }

    private static File osStreamDir;

    /**
     * @param inputStream  получаем имя директории
     * @param outputStream получаем путь
     * @throws IOException
     */
    public static void createDir(File inputStream, File outputStream) throws IOException {
        osStreamDir = new File((outputStream + "\\" + inputStream.getName())); // создаем путь
        osStreamDir.mkdir(); // создаем по заданному пути директорию
    }

    private static File osStreamFile;


    public static void createFile(File inputStream, File outputStream) throws IOException {
        osStreamFile = new File((outputStream + "\\" + inputStream.getName())); // создаем путь
        osStreamFile.createNewFile(); // создаем по заданному пути файл
    }

    public static void relocateFile(File is, File os) throws IOException {
        createFile(is, os);

        try (FileInputStream fileInputStream = new FileInputStream(is);
             FileOutputStream fileOutputStream = new FileOutputStream(osStreamFile)) {
            byte[] buffer = new byte[1024];      // перемещаем каждый файл по байтам
            int length;
            while ((length = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
        }
    }
}
