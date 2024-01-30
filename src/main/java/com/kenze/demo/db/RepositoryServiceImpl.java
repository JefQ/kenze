package com.kenze.demo.db;

import com.kenze.demo.db.model.ListOfWordsDto;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RepositoryServiceImpl implements RepositoryService{

    @Override
    public ListOfWordsDto getListOfWords() { 
        ListOfWordsDto listOfWords = new ListOfWordsDto(getFromFile());
        return listOfWords;
    }

    private List<String> getFromFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("input.txt"));
            return lines;

        }catch(IOException e) {
            e.printStackTrace();
            return List.of();
        }

    }
    
}
