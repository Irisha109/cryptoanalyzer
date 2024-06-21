package com.javarush.panova.cryptoanalyzerfx.dao;

public class AlphabetRu implements Alphabet{

    private final Character[] ALPHABET_RU = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я',
                                             'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У','Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Я',
                                                     '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-'};

    @Override
    public Character[] getAlphabet() {
        return ALPHABET_RU;
    }


}
