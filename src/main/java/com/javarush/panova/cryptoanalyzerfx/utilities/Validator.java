package com.javarush.panova.cryptoanalyzerfx.utilities;

import com.javarush.panova.cryptoanalyzerfx.dao.Alphabet;
import com.javarush.panova.cryptoanalyzerfx.dao.AlphabetRu;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public static boolean isValidKey(int key, Character[] alphabet) throws FileManagerException {
        if (key > 0 && key < alphabet.length) {
            return true;
        } else {
            throw new FileManagerException("The key must be greater than zero and less than the length of the alphabet");

        }
    }

    public static boolean isValidInsertKeyField (String textField) throws FileManagerException {

        if (textField == null || textField.isEmpty()) {
            throw new FileManagerException("You must enter a number greater than 0 and and less than " + new AlphabetRu().getAlphabet().length);
        }

        return true;
    }


    public static boolean isFileForWriting(File filePath) throws FileManagerException {
        Path path = filePath.toPath();
        if(!Files.exists(path)){
            throw new FileManagerException("The file " + filePath + " does not exist");
        }
        if(Files.isDirectory(path)){
            throw new FileManagerException("The specified file is a directory");
        }
        if(!Files.isWritable(path)){
            throw new FileManagerException("The specified file is closed for writing");
        }
        return true;
    }

    public static boolean isFileForReading(File filePath) throws FileManagerException {
        Path path = filePath.toPath();
        if(!Files.exists(path)){
            throw new FileManagerException("The file " + filePath + " does not exist");
        }
        if(Files.isDirectory(path)){
            throw new FileManagerException("The specified file is a directory");
        }
        if(!Files.isReadable(path)){
            throw new FileManagerException("The specified file is closed for reading");
        }
        return true;
    }

}