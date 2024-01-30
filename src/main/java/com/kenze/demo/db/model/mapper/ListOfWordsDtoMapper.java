package com.kenze.demo.db.model.mapper;

import org.springframework.stereotype.Component;

import com.kenze.demo.db.model.ListOfWordsDto;
import com.kenze.demo.domain.ListOfWords;

@Component
public class ListOfWordsDtoMapper {
    public ListOfWords map(ListOfWordsDto listOfWordsDto) {
        return new ListOfWords(listOfWordsDto.getWords());
    }
}
