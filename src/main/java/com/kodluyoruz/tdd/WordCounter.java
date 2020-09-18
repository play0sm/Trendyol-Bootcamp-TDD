package com.kodluyoruz.tdd;

import java.util.Objects;

public class WordCounter {
    public void countUniqueWord(String sentence) {
        if(Objects.isNull(sentence)){
            throw new IllegalArgumentException("Sentence can not be null!");
        }
    }
}
