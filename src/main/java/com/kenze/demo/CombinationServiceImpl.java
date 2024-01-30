package com.kenze.demo;

import org.springframework.stereotype.Component;

import com.kenze.demo.db.RepositoryService;
import com.kenze.demo.db.model.mapper.ListOfWordsDtoMapper;
import com.kenze.demo.domain.ListOfWords;
import com.kenze.demo.service.CombinationService;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;

@Component
public class CombinationServiceImpl implements CombinationService{

    private final RepositoryService repository;
    private final ListOfWordsDtoMapper mapper;

    public CombinationServiceImpl(RepositoryService repositoryService, ListOfWordsDtoMapper mapper) {
        this.mapper = mapper;
        this.repository = repositoryService;
    }

    @Override
    public List<String> getCombinations(int length) {
        ListOfWords list = mapper.map(repository.getListOfWords());
        return getCombinations(list, length);
    }

    private List<String> getCombinations(ListOfWords listOfWords, int length) {
        List<String> result = new ArrayList<>();
        List<String> noDoubleList = removeDubbels(listOfWords.getWords());
        noDoubleList.stream().forEach(word -> {
            noDoubleList.stream().forEach(r -> {
                if (checkLength(word, r, length) && noDoubleList.contains(word+r)) {
                    result.add(String.format("%s+%s=%s",word, r , word+r));
                }
            });
        });
        return result;
    }

    private boolean checkLength(String word1, String word2, int length) {
        return word1.length()+word2.length() == length;
    }

    private List<String> removeDubbels(List<String> list) {
        Set<String> set = new LinkedHashSet<>(list);
        List<String> result = new ArrayList<>(set);
        return result;
    }
    
}
