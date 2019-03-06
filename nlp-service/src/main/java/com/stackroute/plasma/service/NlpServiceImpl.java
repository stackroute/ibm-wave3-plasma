package com.stackroute.plasma.service;

import com.stackroute.plasma.model.NlpModel;
import com.stackroute.plasma.model.UserQuery;
import com.stackroute.plasma.repository.NlpRepository;
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
public class NlpServiceImpl implements NlpService{

    @Autowired
    NlpRepository nlpRepository;
    @Autowired
    RabbitMQSender rabbitMQSender;
    @Override
    public UserQuery save(UserQuery userQuery) {
        return nlpRepository.save(userQuery);
    }

    private final static HashSet<String> stopWordSet = new HashSet<>();
    NlpModel nlpModel = new NlpModel();
    List<String> extractedString;
    @Autowired
    StanfordCoreNLP stanfordCoreNLP;



    public static HashSet<String> getStopWordSet() {
        return stopWordSet;
    }


    public NlpServiceImpl() {
    }


    public HashSet<String> readStopWordCsvFile() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dictionary/stopwords.csv"));
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

        extractedString = new ArrayList<>();
        CoreDocument coreDocument = new CoreDocument(query);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabels = coreDocument.tokens();
        String lemma;

        HashSet<String> word;
        word = readStopWordCsvFile();
        System.out.println("stopwords check");
        System.out.println(word);
        for (CoreLabel coreLabel: coreLabels
        ) {
            lemma = coreLabel.lemma();
            if (!(word.contains(lemma))) {

                extractedString.add(lemma);
            }
        }
        NlpModel nlpModel = new NlpModel(extractedString);


        rabbitMQSender.sender(nlpModel);
        System.out.println("service output"+nlpModel);

        return extractedString;
    }
}
