package com.stackroute.plasma.service;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class NlpServiceImpl {

    private final static HashSet<String> stopWordSet = new HashSet<>();
    List<String> extractedString = new ArrayList<>();

    @Autowired
    StanfordCoreNLP stanfordCoreNLP;



    public static HashSet<String> getStopWordSet() {
        return stopWordSet;
    }


    public NlpServiceImpl() {
    }

    public HashSet<String> readStopWordCsvFile() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/sunil/Desktop/plasma/ibm-wave3-plasma/nlp-service/src/main/java/com/stackroute/plasma/dictionary/stopwords.csv"));
            String stopWordLine = "";
            stopWordLine = stopWordLine + bufferedReader.readLine() + " ";
            while (bufferedReader.readLine() != null){
                stopWordLine = stopWordLine + bufferedReader.readLine() + " ";
            }
            String splitStopWord[] = stopWordLine.split(" ");
            for (String splitWord: splitStopWord
            ) {
                stopWordSet.add(splitWord);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stopWordSet;
    }

    public List<String> queryConverter(String query) {
        CoreDocument coreDocument = new CoreDocument(query);
        stanfordCoreNLP.annotate(coreDocument);
        // System.out.println(stopWord.getList());
        List<CoreLabel> coreLabels = coreDocument.tokens();
        String lemma;

        HashSet<String> word;
        word = readStopWordCsvFile();
        System.out.println(word);
        for (CoreLabel coreLabel: coreLabels
        ) {
            lemma = coreLabel.lemma();
            if (!(word.contains(lemma))) {
                System.out.println("goooood");
                System.out.println(lemma);
                extractedString.add(lemma);
            }
            // finalString.add(lemma);
            // System.out.println(lemma);
        }
        // return coreLabels.stream().map(CoreLabel::originalText).collect(Collectors.toList());
        return extractedString.stream().map(String::toString).collect(Collectors.toList());
    }
        // return null;
   // }

}
