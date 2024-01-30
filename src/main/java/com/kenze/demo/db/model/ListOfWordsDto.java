package com.kenze.demo.db.model;
import java.util.List;

public class ListOfWordsDto {
    private List<String> words;

    public ListOfWordsDto(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return this.words;
    }
}
