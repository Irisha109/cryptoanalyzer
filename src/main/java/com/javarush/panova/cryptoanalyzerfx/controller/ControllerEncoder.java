package com.javarush.panova.cryptoanalyzerfx.controller;

import com.javarush.panova.cryptoanalyzerfx.services.Encrypt;
import com.javarush.panova.cryptoanalyzerfx.utilities.FileManager;
import com.javarush.panova.cryptoanalyzerfx.utilities.FileManagerException;

import java.io.File;
import java.util.List;


public class ControllerEncoder {
    private Encrypt encrypt;


    public ControllerEncoder(Encrypt encrypt) {
        this.encrypt = encrypt;

    }

    public void encrypt(File inputFileName, File outputFileName, int key) throws FileManagerException {
        List<String> list = FileManager.readFile(inputFileName);
        String result;
        for (String str : list) {
            result = encrypt.encrypt(str, key);
            FileManager.writeFile(result, outputFileName);
            FileManager.writeFile(System.lineSeparator(), outputFileName);
        }

    }


}
