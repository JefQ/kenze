package com.kenze.demo.mapper;

import org.junit.jupiter.api.Test;

import com.kenze.demo.db.model.ListOfWordsDto;
import com.kenze.demo.db.model.mapper.ListOfWordsDtoMapper;
import com.kenze.demo.domain.ListOfWords;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class ListOfWordsDtoMapperTest {
    private final ListOfWordsDtoMapper mapper = new ListOfWordsDtoMapper();

    @Test
    void testMap() {
        ListOfWordsDto listOfWordsDto = new ListOfWordsDto(List.of(
            "test",
            "test",
            "testtest"
        ));

        ListOfWords listOfWords = new ListOfWords(List.of(
            "test",
            "test",
            "testtest"
        ));

        assertEquals(mapper.map(listOfWordsDto).getWords(), listOfWords.getWords());
    }
}
