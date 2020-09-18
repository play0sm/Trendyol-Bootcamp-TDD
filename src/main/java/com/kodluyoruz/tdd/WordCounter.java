package com.kodluyoruz.tdd;

import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    public int countUniqueWord(String sentence) {
        if (Objects.isNull(sentence)) {
            throw new IllegalArgumentException("Sentence can not be null!");
        }
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(sentence);

        HashMap<String, Integer> wordMap = new HashMap<>();

        while (matcher.find()) {
            String word = matcher.group();
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }

        return wordMap.keySet().size();
    }
}
