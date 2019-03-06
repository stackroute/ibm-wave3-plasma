package com.stackroute.taggingservice.service;

import com.stackroute.taggingservice.domain.TagOutput;
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
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    StanfordCoreNLP stanfordCoreNLP;
    List<String> taggedString;
    private List<String> concept = new ArrayList<>();
    private List<String> intent = new ArrayList<>();
    private List<String> basic_word_set = new ArrayList<>();
    private List<String> tutorial_word_set = new ArrayList<>();
    private List<String> reference_word_set = new ArrayList<>();
    private List<String> trouble_word_set = new ArrayList<>();
    private List<String> started_word_set = new ArrayList<>();
    private List<String> example_word_set = new ArrayList<>();
    private List<String> finalConcept
    = new ArrayList<>();
    private List<String> finalIntent
    = new ArrayList<>();
    private final static   ArrayList<String> concept_word_set = new ArrayList<>();
    private final static  ArrayList<String> intent_word_set = new ArrayList<>();
    private TagOutput tagOutput = new TagOutput(new ArrayList<>(),new ArrayList<>());

    @Autowired
    RabbitMQSender rabbitMQSender;
    public TagServiceImpl() {
        readConceptFile();
        System.out.println(readConceptFile());

        readTutorialFile();
        System.out.println(readTutorialFile());

        readTroubleShootingFile();

        readReferenceFile();

        readExampleFile();

        readBasicFile();

        readGettingStartedFile();

        readIntentFile();

    }
    public ArrayList<String> readIntentFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/intent.csv"));
            String intent_word = "";
            try {
                intent_word = intent_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    intent_word = intent_word + bufferedReader.readLine() + " ";
                }
                String[] intent_word_split = intent_word.split(" ");
                for (String intent_word_split_single:intent_word_split
                     ) {
                    intent_word_set.add(intent_word_split_single.toLowerCase().trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return intent_word_set;
    }

    public List<String> readBasicFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/basic.csv"));
            String basic_word = "";
            try {
                basic_word = basic_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    basic_word = basic_word + bufferedReader.readLine() + " ";
                }
                String[] basic_word_split = basic_word.split(" ");
                for (String basic_word_split_single:basic_word_split
                ) {
                    basic_word_set.add(basic_word_split_single.toLowerCase().trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return basic_word_set;
    }

    public List<String> readTutorialFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/tutorials.csv"));
            String tutorial_word = "";
            try {
                tutorial_word = tutorial_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    tutorial_word = tutorial_word + bufferedReader.readLine() + " ";
                }
                String[] tutorial_word_split = tutorial_word.split(" ");
                for (String tutorial_word_split_single:tutorial_word_split
                ) {
                    tutorial_word_set.add(tutorial_word_split_single.toLowerCase().trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tutorial_word_set;
    }

    public List<String> readReferenceFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/reference.csv"));
            String reference_word = "";
            try {
                reference_word = reference_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    reference_word = reference_word + bufferedReader.readLine() + " ";
                }
                String[] reference_word_split = reference_word.split(" ");
                for (String reference_word_split_single:reference_word_split
                ) {
                    reference_word_set.add(reference_word_split_single.toLowerCase().trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reference_word_set;
    }

    public ArrayList<String> readConceptFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/concept.csv"));
            String concept_word = "";
            try {
                concept_word = concept_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    concept_word = concept_word + bufferedReader.readLine() + " ";
                }
                String[] concept_word_split = concept_word.split(",");
                for (String concept_word_split_single:concept_word_split
                ) {
                    concept_word_set.add(concept_word_split_single.toLowerCase().toLowerCase().trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return concept_word_set;
    }

    public List<String> readTroubleShootingFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/trouleshooting.csv"));
            String trouble_word = "";
            try {
                trouble_word = trouble_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    trouble_word = trouble_word + bufferedReader.readLine() + " ";
                }
                String[] trouble_word_split = trouble_word.split(" ");
                for (String trouble_word_split_single:trouble_word_split
                ) {
                    trouble_word_set.add(trouble_word_split_single.toLowerCase().trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return trouble_word_set;
    }


    public List<String> readGettingStartedFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/gettingstarted.csv"));
            String started_word = "";
            try {
                started_word = started_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    started_word = started_word + bufferedReader.readLine() + " ";
                }
                String[] started_word_split = started_word.split(" ");
                for (String started_word_split_single:started_word_split
                ) {
                    started_word_set.add(started_word_split_single.toLowerCase().trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return started_word_set;
    }

    public List<String> readExampleFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/example.csv"));
            String example_word = "";
            try {
                example_word = example_word + bufferedReader.readLine() + "";
                while (bufferedReader.readLine() != null){
                    example_word = example_word + bufferedReader.readLine() + " ";
                }
                String[] example_word_split = example_word.split(" ");
                for (String example_word_split_single:example_word_split
                ) {
                    example_word_set.add(example_word_split_single.toLowerCase().trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return example_word_set;
    }

    public List<String> checkForConcept() {

        finalConcept = new ArrayList<>();
        for(int i=0;i<concept.size();i++){
            if((concept_word_set.contains(concept.get(i).toLowerCase().trim()))) {
                finalConcept.add(concept.get(i).toLowerCase().trim());
            }
        }
        if (finalConcept.isEmpty()){
            finalConcept.add("resource not found");
            return finalConcept;
        }
        else {
            return finalConcept;
        }

    }


    public List<String> checkForIntent() {

        finalIntent = new ArrayList<>();
        for(int i=0;i<intent.size();i++){
           if (basic_word_set.contains(intent.get(i).toLowerCase().trim())){
               finalIntent.add("basics");
           }
           if (example_word_set.contains(intent.get(i).toLowerCase().trim())){
               finalIntent.add("example");
           }
           if (started_word_set.contains(intent.get(i).toLowerCase().trim())){
                finalIntent.add("gettingstarted");
           }
           if (reference_word_set.contains(intent.get(i).toLowerCase().trim())){
                finalIntent.add("completereference");
           }
           if (trouble_word_set.contains(intent.get(i).toLowerCase().trim())){
                finalIntent.add("troubleshooting");
           }
           if (tutorial_word_set.contains(intent.get(i).toLowerCase().trim())){
                finalIntent.add("tutorial");
           }
        }
        if(intent.isEmpty()){
             finalIntent.add("basics");
             return finalIntent;
        }
        else{
            return finalIntent;
        }
    }

    @Override
    public TagOutput tagger(String lemma) {
        System.out.println(lemma);
        taggedString = new ArrayList<>();
        intent = new ArrayList<>();
        concept = new ArrayList<>();
        CoreDocument coreDocument = new CoreDocument(lemma);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabels = coreDocument.tokens();
        for (CoreLabel coreLabel:coreLabels
             ) {
            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            if(pos.equals("NN") || pos.equals("NNS") || pos.equals("NNP")
                    || pos.equals("NNPS") || pos.equals("JJ")
                    || pos.equals("JJR") || pos.equals("JJS")) {

                concept.add(coreLabel.originalText());
            }
            else if(pos.equals("WP") || pos.equals("VB") || pos.equals("VBP") || pos.equals("IN") ) {
                    intent.add(coreLabel.originalText());
            }
            else{
                taggedString.add(coreLabel.originalText());
            }
        }



        checkForConcept();
        checkForIntent();
        tagOutput.setTaggedConcept(finalConcept);
        tagOutput.setTaggedLevel(finalIntent);

        TagOutput tagOutput = new TagOutput(finalConcept,finalIntent);



        System.out.println("sending message to RabbitMQ toString: " + tagOutput);
        rabbitMQSender.sender(tagOutput);
        return tagOutput;
    }
}

