package com.stackroute.conceptstorage.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConceptServiceImpl implements ConceptService {
    List<String> conceptWordSet = new ArrayList<>();
    public List<String> getConcept(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dictionary/concepts.csv"));
            String conceptWord = "";
            conceptWord = conceptWord + bufferedReader.readLine() + ",";
            String line;
            do{
                line = bufferedReader.readLine();
                conceptWord = conceptWord + line + ",";
            }while(line!=null);
            String splitConceptWord[] = conceptWord.split("\n");
            for (String splitWord: splitConceptWord
            ) {
                conceptWordSet.add(splitWord);
            }
            System.out.println(conceptWordSet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conceptWordSet;
    }

}
