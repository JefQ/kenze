package com.kenze.demo.domain;
import java.util.List;

public class ListOfWords {
    private List<String> words;

    public ListOfWords(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return this.words;
    }
}
