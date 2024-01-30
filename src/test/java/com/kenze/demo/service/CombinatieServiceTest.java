package com.kenze.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kenze.demo.CombinationServiceImpl;
import com.kenze.demo.db.RepositoryService;
import com.kenze.demo.db.model.ListOfWordsDto;
import com.kenze.demo.db.model.mapper.ListOfWordsDtoMapper;
import com.kenze.demo.domain.ListOfWords;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CombinatieServiceTest {

    @Mock
    private RepositoryService repositoryService;

    @Mock
    private ListOfWordsDtoMapper mapper;

    @InjectMocks
    private CombinationServiceImpl combinationService;

    @Test
    void testGetCombionations() {
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

        Mockito.when(repositoryService.getListOfWords()).thenReturn(listOfWordsDto);
        Mockito.when(mapper.map(listOfWordsDto)).thenReturn(listOfWords);

        List<String> result = combinationService.getCombinations(8);
        assertEquals(1, result.size());
    }

    @Test
    void testGetCombionationsNoResult() {
        ListOfWordsDto listOfWordsDto = new ListOfWordsDto(List.of(
            "test",
            "test"
        ));

        ListOfWords listOfWords = new ListOfWords(List.of(
            "test",
            "test"
        ));

        Mockito.when(repositoryService.getListOfWords()).thenReturn(listOfWordsDto);
        Mockito.when(mapper.map(listOfWordsDto)).thenReturn(listOfWords);

        List<String> result = combinationService.getCombinations(8);
        assertEquals(0, result.size());
    }

    @Test
    void testGetCombionationsWhenNull() {
        ListOfWordsDto listOfWordsDto = new ListOfWordsDto(List.of(
            "test",
            "test",
            "testtest"
        ));

        ListOfWords listOfWords = null;

        Mockito.when(repositoryService.getListOfWords()).thenReturn(listOfWordsDto);
        Mockito.when(mapper.map(listOfWordsDto)).thenReturn(listOfWords);

        List<String> result = combinationService.getCombinations(9);
        assertEquals(0, result.size());
    }

    @Test
    void testGetCombionationsWithMultipleWords() {
        ListOfWordsDto listOfWordsDto = new ListOfWordsDto(List.of(
            "te",
            "st",
            "test",
            "testtest"
        ));

        ListOfWords listOfWords = new ListOfWords(List.of(
            "te",
            "st",
            "test",
            "testtest"
        ));

        Mockito.when(repositoryService.getListOfWords()).thenReturn(listOfWordsDto);
        Mockito.when(mapper.map(listOfWordsDto)).thenReturn(listOfWords);

        List<String> result = combinationService.getCombinations(8);
        assertEquals(5, result.size());
    }
}
