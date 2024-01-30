package com.kenze.demo.db.model.mapper;


import org.springframework.stereotype.Component;

import com.kenze.demo.db.model.ListOfWordsDto;
import com.kenze.demo.domain.ListOfWords;

@Component
public class ListOfWordsDtoMapper {
    public ListOfWords map(ListOfWordsDto listOfWordsDto) {
        if (listOfWordsDto == null) {
            return new ListOfWords();
        }
        return new ListOfWords(listOfWordsDto.getWords());
    }
}
