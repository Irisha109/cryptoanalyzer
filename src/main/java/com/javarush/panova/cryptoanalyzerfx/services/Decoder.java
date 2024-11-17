package com.javarush.panova.cryptoanalyzerfx.services;

public interface Decoder {
    String decrypt(String text, int shift);
}
