package com.javarush.panova.cryptoanalyzerfx.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final StandardOpenOption[] FILE_OPTIONS = {StandardOpenOption.CREATE, StandardOpenOption.APPEND};

    private FileManager(){

    }

    public static List<String> readFile(File filePath) throws FileManagerException {
        List<String> list = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());
            }
        }catch (IOException ex){
            System.out.println("Error reading file");
            throw new FileManagerException(ex.getMessage(), ex);
        }
        return list;
    }

    public static void writeFile(String text, File filePath) throws FileManagerException {
        try{
        Path path = filePath.toPath();
        Files.writeString(path, text, FILE_OPTIONS);
        }catch (IOException ex){
            System.out.println("Error writing file");
            throw new FileManagerException(ex.getMessage(), ex);

        }
    }



}
