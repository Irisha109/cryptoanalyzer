package com.javarush.panova.cryptoanalyzerfx.services;

import com.javarush.panova.cryptoanalyzerfx.dao.Alphabet;

import java.util.Arrays;

public class CaesarCipherDecrypt implements Decoder{

   private Character[] arrayAlphabet;

    public CaesarCipherDecrypt(Alphabet alphabet) {
        this.arrayAlphabet = alphabet.getAlphabet();
    }
    public void setArrayAlphabet(Character[] arrayAlphabet) {
        this.arrayAlphabet = arrayAlphabet;
    }
    @Override
    public String decrypt(String text, int shift) {

        StringBuilder decodingText = new StringBuilder();
        char symbol;
        int index;
        Arrays.sort(arrayAlphabet);

        for (int i = 0; i < text.length(); i++) {
             symbol = text.charAt(i);
             index = Arrays.binarySearch(arrayAlphabet, symbol);
            if(index < 0){
                continue;
            }
            int newIndex = (index < shift) ? arrayAlphabet.length - (shift - index) : index - shift;
            decodingText.append(arrayAlphabet[newIndex]);
        }
        return decodingText.toString();
    }

}
