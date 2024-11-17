package com.javarush.panova.cryptoanalyzerfx.controller;

import com.javarush.panova.cryptoanalyzerfx.language.AlphabetRu;
import com.javarush.panova.cryptoanalyzerfx.services.BruteForceDecrypt;
import com.javarush.panova.cryptoanalyzerfx.services.CaesarCipherDecrypt;
import com.javarush.panova.cryptoanalyzerfx.services.Encrypt;
import com.javarush.panova.cryptoanalyzerfx.utilities.FileManagerException;
import com.javarush.panova.cryptoanalyzerfx.utilities.Validator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class ControllerCryptoanalyzer {
    private File originalFile;
    private File encryptFile;
    private FileChooser fileChooser = new FileChooser();
    private AlphabetRu alphabetRu = new AlphabetRu();
    private Encrypt encrypt = new Encrypt(alphabetRu);
    private ControllerEncoder controllerEncoder = new ControllerEncoder(encrypt);
    private CaesarCipherDecrypt caesarCipherDecrypt = new CaesarCipherDecrypt(alphabetRu);
    private ControllerDecoder controllerDecoder = new ControllerDecoder(caesarCipherDecrypt);
    private File encryptFileCaesar;
    private File decryptFileCaesar;
    private File encryptFileBruteForce;
    private File decryptFileBruteForce;
    private BruteForceDecrypt bruteForceDecrypt = new BruteForceDecrypt(alphabetRu);
    private ControllerDecoder controllerDecoderBruteForce = new ControllerDecoder(bruteForceDecrypt);

    //------------------------ENCRYPT CAESAR------OK-------------------------------------------

    @FXML
    protected void onChooseOriginFileButtonClick() {
        originalFile = fileChooser.showOpenDialog(null);
        try {
            Validator.isFileForReading(originalFile);
        } catch (FileManagerException ex) {
            originFileExceptionEncrypt.setText(ex.getMessage());
        }
    }

    @FXML
    protected TextField insertKeyField;

    @FXML
    protected void onChooseEncryptFileButtonClick() {
        encryptFile = fileChooser.showOpenDialog(null);
        try {
            Validator.isFileForWriting(encryptFile);

        } catch (FileManagerException ex) {
            resultFileExceptionEncrypt.setText(ex.getMessage());
        }
    }

    @FXML
    protected void onDoEncryptButtonClick() {
        String keyFieldText = insertKeyField.getText();
        int key;
        try {
            if (Validator.isValidInsertKeyField(keyFieldText)) {
                 key = Integer.parseInt(keyFieldText);
                if (Validator.isValidKey(key, alphabetRu.getAlphabet())){
                    controllerEncoder.encrypt(originalFile, encryptFile, key);
                }
            }
        } catch (FileManagerException ex) {
            keyExceptionEncrypt.setText(ex.getMessage());
        }
    }


    @FXML
    private Label originFileExceptionEncrypt;

    @FXML
    private Label keyExceptionEncrypt;

    @FXML
    private Label resultFileExceptionEncrypt;

//---------------------------DECRYPT CAESAR---------OK---------------------------------------

    @FXML
    protected void onChooseEncryptFileCaesarButtonClick() {
        encryptFileCaesar = fileChooser.showOpenDialog(null);
        try {
            Validator.isFileForReading(encryptFileCaesar);
        } catch (FileManagerException ex) {
            encryptFileExceptionCaesar.setText(ex.getMessage());
        }
    }

    @FXML
    protected TextField keyCaesarField;

    @FXML
    protected void onChooseDecryptFileCaesarButtonClick() {
        decryptFileCaesar = fileChooser.showOpenDialog(null);
        try{
            Validator.isFileForWriting(decryptFileCaesar);
        }catch (FileManagerException ex){
            resultFileExceptionCaesar.setText(ex.getMessage());
        }
    }

    @FXML
    protected void onDoDecryptCaesarButtonClick() {
        String keyFieldText = keyCaesarField.getText();
        int key;
        try {
            if (Validator.isValidInsertKeyField(keyFieldText)) {
                key = Integer.parseInt(keyFieldText);
                if (Validator.isValidKey(key, alphabetRu.getAlphabet())){
                    controllerDecoder.decrypt(encryptFileCaesar, decryptFileCaesar, key);
                }
            }
        } catch (FileManagerException ex) {
            keyExceptionCaesar.setText(ex.getMessage());
        }
    }

    @FXML
    private Label encryptFileExceptionCaesar;

    @FXML
    private Label keyExceptionCaesar;

    @FXML
    private Label resultFileExceptionCaesar;

    //-----------------------DECRYPT BRUTE FORCE---------------------------------------------------
    @FXML
    protected void onChooseEncryptFileBruteForceButtonClick() {
        encryptFileBruteForce = fileChooser.showOpenDialog(null);
        try {
            Validator.isFileForReading(encryptFileBruteForce);
        } catch (FileManagerException ex) {
            encryptFileExceptionBruteForce.setText(ex.getMessage());
        }
    }

    @FXML
    protected void onChooseDecryptFileBruteForceButtonClick() {
        decryptFileBruteForce = fileChooser.showOpenDialog(null);
        try {
            Validator.isFileForWriting(decryptFileBruteForce);
        } catch (FileManagerException ex) {
            resultFileExceptionBruteForce.setText(ex.getMessage());
        }
    }

    @FXML
    protected void onDoDecryptBruteForceButtonClick() {
        try {

               controllerDecoderBruteForce.decrypt(encryptFileBruteForce, decryptFileBruteForce, 0);


        } catch (FileManagerException ex) {
            keyExceptionCaesar.setText(ex.getMessage());
        }
    }

    @FXML
    private Label encryptFileExceptionBruteForce;

    @FXML
    private Label resultFileExceptionBruteForce;

}