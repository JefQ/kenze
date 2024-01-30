package com.kenze.demo.domain;
import java.util.List;
import java.util.ArrayList;

public class ListOfWords {
    private List<String> words;

    public ListOfWords() {
        this.words = new ArrayList<>();
    }

    public ListOfWords(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return this.words;
    }
}
