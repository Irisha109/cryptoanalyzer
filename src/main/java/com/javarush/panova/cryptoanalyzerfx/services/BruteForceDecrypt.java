package com.javarush.panova.cryptoanalyzerfx.services;

import com.javarush.panova.cryptoanalyzerfx.language.Alphabet;

import java.util.HashMap;
import java.util.Map;


public class BruteForceDecrypt implements Decoder {
    private final Character[] arrayAlphabet;

    private final CaesarCipherDecrypt cipherDecrypt;


    public BruteForceDecrypt(Alphabet alphabet) {
        this.arrayAlphabet = alphabet.getAlphabet();
        this.cipherDecrypt = new CaesarCipherDecrypt(alphabet);

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
        for (char character : characters) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        int count_a = map.getOrDefault('а', 0);
        int count_A = map.getOrDefault('А', 0);
        int count_o = map.getOrDefault('о', 0);
        int count_O = map.getOrDefault('О', 0);
        int count_i = map.getOrDefault('и', 0);
        int count_I = map.getOrDefault('И', 0);
        int count_e = map.getOrDefault('е', 0);
        int count_E = map.getOrDefault('Е', 0);
        int count_space = map.getOrDefault(' ', 0);


        int mostCommonChar = count_a + count_A + count_o + count_O
                + count_i + count_I + count_e + count_E + count_space;

        double percentage = (mostCommonChar * 1.0) / characters.length * 100;
        double approximateSymbolFrequency = 35.0;

        return percentage > approximateSymbolFrequency;

    }


}
