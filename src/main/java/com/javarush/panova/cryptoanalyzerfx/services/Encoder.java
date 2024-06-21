package com.javarush.panova.cryptoanalyzerfx.services;

import com.javarush.panova.cryptoanalyzerfx.dao.Alphabet;

import java.util.Arrays;

public class Encoder {
    private Character[] arrayAlphabet;

    public Encoder(Alphabet alphabet) {
        this.arrayAlphabet = alphabet.getAlphabet();
    }

    public void setAlphabet(Character[] alphabet) {
        this.arrayAlphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        StringBuilder encodingText = new StringBuilder();
        Arrays.sort(arrayAlphabet);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = Arrays.binarySearch(arrayAlphabet, c);
            if(index < 0){continue;}
            int newIndex = index + shift;
            if(newIndex >= arrayAlphabet.length) {
                newIndex %= arrayAlphabet.length;
            }
            encodingText.append(arrayAlphabet[newIndex]);
        }
        return encodingText.toString();
    }


}
