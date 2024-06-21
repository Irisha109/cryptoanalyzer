package com.javarush.panova.cryptoanalyzerfx.services;

import com.javarush.panova.cryptoanalyzerfx.dao.Alphabet;

import java.util.HashMap;
import java.util.Map;


public class BruteForceDecrypt implements Decoder {
    private Character[] arrayAlphabet;

    private final CaesarCipherDecrypt cipherDecrypt;


    public BruteForceDecrypt(Alphabet alphabet) {
        this.arrayAlphabet = alphabet.getAlphabet();
        this.cipherDecrypt = new CaesarCipherDecrypt(alphabet);

    }

    public void setValueAlphabet(Character[] valueAlphabet) {
        this.arrayAlphabet = valueAlphabet;
    }

    @Override
    public String decrypt(String encryptedText, int shift){
        for (int i = 1; i < arrayAlphabet.length; i++) {
            String decryptedText = cipherDecrypt.decrypt(encryptedText, i);
            if(isCorrectDecoding(decryptedText)){
                return decryptedText;
            }
        }
        return "Could not be decrypted";
    }

    private boolean isCorrectDecoding(String string){
        Map<Character, Integer> map = new HashMap<>();
        char[] characters = string.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            map.put(characters[i], map.getOrDefault(characters[i], 0) + 1);
        }
        int count_a = map.containsKey('а') ? map.get('а') : 0;
        int count_A = map.containsKey('А') ? map.get('А') : 0;
        int count_o = map.containsKey('о') ? map.get('о') : 0;
        int count_O = map.containsKey('О') ? map.get('О') : 0;
        int count_i = map.containsKey('и') ? map.get('и') : 0;
        int count_I = map.containsKey('И') ? map.get('И') : 0;
        int count_e = map.containsKey('е') ? map.get('е') : 0;
        int count_E = map.containsKey('Е') ? map.get('Е') : 0;
        int count_space = map.containsKey(' ') ? map.get(' ') : 0;


        int mostCommonChar = count_a + count_A + count_o + count_O
                + count_i + count_I + count_e + count_E + count_space;

        double percentage = (mostCommonChar * 1.0) / characters.length * 100;
        double approximateSymbolFrequency = 35.0;

        return percentage > approximateSymbolFrequency;

    }


}
