package com.javarush.panova.cryptoanalyzerfx.controller;

import com.javarush.panova.cryptoanalyzerfx.dao.Alphabet;
import com.javarush.panova.cryptoanalyzerfx.services.Encoder;
import com.javarush.panova.cryptoanalyzerfx.utilities.FileManager;
import com.javarush.panova.cryptoanalyzerfx.utilities.FileManagerException;
import com.javarush.panova.cryptoanalyzerfx.utilities.Validator;

import java.io.File;
import java.util.List;


public class ControllerEncoder {
    private Encoder encoder;


    public ControllerEncoder(Encoder encoder) {
        this.encoder = encoder;

    }

    public void encrypt(File inputFileName, File outputFileName, int key) throws FileManagerException {
        List<String> list = FileManager.readFile(inputFileName);
        String result;
        for (String str : list) {
            result = encoder.encrypt(str, key);
            FileManager.writeFile(result, outputFileName);
            FileManager.writeFile(System.lineSeparator(), outputFileName);
        }

    }


}
