package com.stackroute.taggingservice.service;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
public class TagServiceImpl implements TagService {

    @Autowired
    StanfordCoreNLP stanfordCoreNLP;
    List<String> taggedString;
    private final static HashSet<String> intent_word_set = new HashSet<>();
    private final static HashSet<String> concept_word_set = new HashSet<>();

    public TagServiceImpl() {
    }

    public HashSet<String> readIntentFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/sunil/Desktop/plasma/v1.0.1/ibm-wave3-plasma/tagging-service/src/main/java/com/stackroute/taggingservice/dictionary/intent.csv"));
            String intent_word = "";
            try {
                intent_word = intent_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    intent_word = intent_word + bufferedReader.readLine() + " ";
                }
                String[] intent_word_split = intent_word.split(" ");
                for (String intent_word_split_single:intent_word_split
                     ) {
                    intent_word_set.add(intent_word_split_single);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return intent_word_set;
    }


    public HashSet<String> readConceptFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/sunil/Desktop/plasma/v1.0.1/ibm-wave3-plasma/tagging-service/src/main/java/com/stackroute/taggingservice/dictionary/concept.csv"));
            String concept_word = "";
            try {
                concept_word = concept_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    concept_word = concept_word + bufferedReader.readLine() + " ";
                }
                String[] concept_word_split = concept_word.split("\\n");
                for (String intent_word_split_single:concept_word_split
                ) {
                    concept_word_set.add(intent_word_split_single);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return concept_word_set;
    }


    @Override
    public String[] tagger(String lemma) {
        taggedString = new ArrayList<>();
        CoreDocument coreDocument = new CoreDocument(lemma);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabels = coreDocument.tokens();
        for (CoreLabel coreLabel:coreLabels
             ) {
            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            taggedString.add(pos);
            System.out.println(taggedString);
            System.out.println(coreLabel.originalText() + "====" + pos);
        }
        System.out.println(readConceptFile());
        System.out.println("*******************");
        System.out.println(readIntentFile());

        return new String[0];
    }
}

//    private final static HashSet<String> stopWordSet = new HashSet<>();
//    // List<String> extractedString = new ArrayList<>();
//    List<String> extractedString;
//    @Autowired
//    StanfordCoreNLP stanfordCoreNLP;



//    public static HashSet<String> getStopWordSet() {
//        return stopWordSet;
//    }
//
//
//    public NlpServiceImpl() {
//    }
//    //method for reading csv file
//    public HashSet<String> readStopWordCsvFile() {
//
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/sunil/Desktop/plasma/ibm-wave3-plasma/nlp-service/src/main/java/com/stackroute/plasma/dictionary/stopwords.csv"));
//            String stopWordLine = "";
//            stopWordLine = stopWordLine + bufferedReader.readLine() + " ";
//            while (bufferedReader.readLine() != null){
//                stopWordLine = stopWordLine + bufferedReader.readLine() + " ";
//            }
//            String splitStopWord[] = stopWordLine.split(" ");
//            for (String splitWord: splitStopWord
//            ) {
//                stopWordSet.add(splitWord);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return stopWordSet;
//    }
//
//    public List<String> queryConverter(String query) {
//        extractedString = new ArrayList<>();
//        CoreDocument coreDocument = new CoreDocument(query);
//        stanfordCoreNLP.annotate(coreDocument);
//        List<CoreLabel> coreLabels = coreDocument.tokens();
//        String lemma;
//
//        HashSet<String> word;
//        word = readStopWordCsvFile();
//        //System.out.println(coreLabels);
//        for (CoreLabel coreLabel: coreLabels
//        ) {
