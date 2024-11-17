package com.javarush.panova.cryptoanalyzerfx.controller;

import com.javarush.panova.cryptoanalyzerfx.services.Decoder;
import com.javarush.panova.cryptoanalyzerfx.utilities.FileManager;
import com.javarush.panova.cryptoanalyzerfx.utilities.FileManagerException;

import java.io.File;
import java.util.List;

public class ControllerDecoder {
    private Decoder decoder;


    public ControllerDecoder(Decoder decoder) {
        this.decoder = decoder;

    }

    public void decrypt(File inputFileName, File outputFileName, int key) throws FileManagerException {
        try{
            List<String> list =  FileManager.readFile(inputFileName);
                String result;
                for (String str: list){
                    result = decoder.decrypt(str, key);
                    FileManager.writeFile(result, outputFileName);
                    FileManager.writeFile(System.lineSeparator(), outputFileName);
                }

        }catch (FileManagerException ex){
            throw new FileManagerException(ex.getMessage(), ex);
        }
    }



}
