package com.stackroute.taggingservice.service;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceImpl implements TagService {

    @Autowired
    StanfordCoreNLP stanfordCoreNLP;
    List<String> taggedString;
    public TagServiceImpl() {
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

        return new String[0];
    }
}

//    private final static HashSet<String> stopWordSet = new HashSet<>();
//    // List<String> extractedString = new ArrayList<>();
//    List<String> extractedString;
//    @Autowired
//    StanfordCoreNLP stanfordCoreNLP;
//
//
//
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
//            lemma = coreLabel.lemma();
//            if (!(word.contains(lemma))) {
//                extractedString.add(lemma);
//            }
//        }
//        return extractedString;
//    }