package com.kenze.demo;

import org.springframework.stereotype.Component;

import com.kenze.demo.db.RepositoryService;
import com.kenze.demo.db.model.mapper.ListOfWordsDtoMapper;
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
        List<String> list = removeDubbels(mapper.map(repository.getListOfWords()).getWords());
        if (list == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        generateCombinations(list, "", length, result);
        return result;
    }

    private static void generateCombinations(List<String> words, String currentCombination, int length, List<String> result) {
        String combination = currentCombination.replaceAll("\\+", "");
        if (combination.length() == length) {
            if (words.contains(combination)) {
                result.add(currentCombination.replaceFirst("\\+", "") + "=" + combination);
            }
            return;
        }

        words.stream().forEach(word -> {
            String newCombination = currentCombination + "+" + word;
            if (newCombination.replaceAll("\\+", "").length() <= length) {
                generateCombinations(words, newCombination, length, result);
            }
        });
    }

    private List<String> removeDubbels(List<String> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        Set<String> set = new LinkedHashSet<>(list);
        List<String> result = new ArrayList<>(set);
        return result;
    }
    
}
