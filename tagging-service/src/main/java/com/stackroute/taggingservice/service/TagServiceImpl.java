package com.stackroute.taggingservice.service;

import com.stackroute.taggingservice.domain.TagOutput;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(TagServiceImpl.class.getName());
    @Autowired
    StanfordCoreNLP stanfordCoreNLP;
    List<String> taggedString;
    private List<String> concept ;//= new ArrayList<>();
    private List<String> intent;// = new ArrayList<>();
    private List<String> intentChecker = new ArrayList<>();
    private List<String> basic_word_set = new ArrayList<>();
    private List<String> tutorial_word_set = new ArrayList<>();
    private List<String> reference_word_set = new ArrayList<>();
    private List<String> trouble_word_set = new ArrayList<>();
    private List<String> started_word_set = new ArrayList<>();
    private List<String> example_word_set = new ArrayList<>();
    private List<String> finalConcept;
//    = new ArrayList<>();
    private List<String> finalIntent;
//    = new ArrayList<>();
    private final static   ArrayList<String> concept_word_set = new ArrayList<>();
    private final static  ArrayList<String> intent_word_set = new ArrayList<>();
    //private TagOutput tagOutput;
    // = new TagOutput();
    @Autowired
    RabbitMQListener rabbitMQListener;

    @Autowired
    RabbitMQSender rabbitMQSender;
    public TagServiceImpl() {
        readConceptFile();
        //System.out.println(readConceptFile());

        readTutorialFile();
        //System.out.println(readTutorialFile());

        readTroubleShootingFile();

        readReferenceFile();

        readExampleFile();

        readBasicFile();

        readGettingStartedFile();

        readIntentFile();

    }
    public ArrayList<String> readIntentFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/intents.csv"));
            String intent_word = "";
            String line;
            try {
//                intent_word = intent_word + bufferedReader.readLine() + "";
//                while (bufferedReader.readLine() != null){
//                    intent_word = intent_word + bufferedReader.readLine() + " ";
//                }
                do{
                    line = bufferedReader.readLine();
                    intent_word = intent_word + line+",";
                }while (line!=null);
                String[] intent_word_split = intent_word.split(",");
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
        System.out.println(intent_word_set);
        return intent_word_set;
    }

    public List<String> readBasicFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/basic.csv"));
            String basic_word = "";
            String line;
            try {
//                basic_word = basic_word + bufferedReader.readLine() + "";
//                while (bufferedReader.readLine() != null){
//                    basic_word = basic_word + bufferedReader.readLine() + " ";
//                }
                do{
                    line = bufferedReader.readLine();
                    basic_word = basic_word + line + ",";
                }while (line!=null);
                String[] basic_word_split = basic_word.split(",");
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
        System.out.println(basic_word_set);
        return basic_word_set;
    }

    public List<String> readTutorialFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/tutorials.csv"));
            String tutorial_word = "";
            String line;
            try {
//                tutorial_word = tutorial_word + bufferedReader.readLine() + "";
//                while (bufferedReader.readLine() != null){
//                    tutorial_word = tutorial_word + bufferedReader.readLine() + " ";
//                }
                do{
                    line = bufferedReader.readLine();
                    tutorial_word = tutorial_word + line + ",";
                }while (line!=null);
                String[] tutorial_word_split = tutorial_word.split(",");
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
        System.out.println(tutorial_word_set);
        return tutorial_word_set;
    }

    public List<String> readReferenceFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/reference.csv"));
            String reference_word = "";
            String line;
            try {
//                reference_word = reference_word + bufferedReader.readLine() + "";
//                while (bufferedReader.readLine() != null){
//                    reference_word = reference_word + bufferedReader.readLine() + " ";
//                }
                do{
                    line = bufferedReader.readLine();
                    reference_word = reference_word + line + ",";
                }while (line!=null);

                String[] reference_word_split = reference_word.split(",");
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
        System.out.println(reference_word_set);
        return reference_word_set;
    }

    public ArrayList<String> readConceptFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/concept.csv"));
            String concept_word = "";
            String line;
            try {
//                concept_word = concept_word + bufferedReader.readLine() + "";
//                while (bufferedReader.readLine() != null){
//                    concept_word = concept_word + bufferedReader.readLine() + " ";
//                }
                do{
                    line = bufferedReader.readLine();
                    concept_word = concept_word + line + ",";
                }while (line!=null);
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
        System.out.println(concept_word_set);
        return concept_word_set;
    }

    public List<String> readTroubleShootingFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/trouleshooting.csv"));
            String trouble_word = "";
            String line;
            try {
//                trouble_word = trouble_word + bufferedReader.readLine() + "";
//                while (bufferedReader.readLine() != null){
//                    trouble_word = trouble_word + bufferedReader.readLine() + " ";
//                }
                do{
                    line = bufferedReader.readLine();
                    trouble_word = trouble_word + line + ",";
                }while (line!=null);

                String[] trouble_word_split = trouble_word.split(",");
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
        System.out.println(tutorial_word_set);
        return trouble_word_set;
    }


    public List<String> readGettingStartedFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/gettingstarted.csv"));
            String started_word = "";
            String line;
            try {
//                started_word = started_word + bufferedReader.readLine() + "";
//                while (bufferedReader.readLine() != null){
//                    started_word = started_word + bufferedReader.readLine() + " ";
//                }
                do{
                    line = bufferedReader.readLine();
                    started_word = started_word + line + ",";
                }while (line!=null);
                String[] started_word_split = started_word.split(",");
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
        System.out.println(started_word_set);
        return started_word_set;
    }

    public List<String> readExampleFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./dict/example.csv"));
            String example_word = "";
            String line;
            try {
//                example_word = example_word + bufferedReader.readLine() + "";
//                while (bufferedReader.readLine() != null){
//                    example_word = example_word + bufferedReader.readLine() + " ";
//                }
                do{
                    line = bufferedReader.readLine();
                    example_word = example_word + line + ",";
                }while (line!=null);
                String[] example_word_split = example_word.split(",");
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
        System.out.println(example_word_set);
        return example_word_set;
    }

    public List<String> checkForConcept() {
        System.out.println(concept);
        finalConcept = new ArrayList<>();
        for(int c=0;c<finalConcept.size();c++){
            finalConcept.remove(c);
        }
        for(int i=0;i<concept.size();i++){
            System.out.println(concept_word_set.contains(concept.get(i).toLowerCase().trim()));

            if((concept_word_set.contains(concept.get(i).toLowerCase().trim()))) {
                finalConcept.add(concept.get(i).toLowerCase().trim());
            }
        }
        if (finalConcept.isEmpty()){
            finalConcept.add("concept-not-found");
            return finalConcept;
        }
        else {
            return finalConcept;
        }

    }


    public List<String> checkForIntent() {
        System.out.println("&&&&&&&&&&&&&&&&&&&"+ intent);
        finalIntent = new ArrayList<>();
        for(int c=0;c<finalIntent.size();c++){
            finalIntent.remove(c);
        }
        for(int i=0;i<intent.size();i++){
            //System.out.println(basic_word_set.contains(intent.get(i).trim().toLowerCase()));
           if ((basic_word_set.contains(intent.get(i).toLowerCase().trim()))){
               finalIntent.add("basics");
               //continue;
           }
           if (example_word_set.contains(intent.get(i).toLowerCase().trim())){
               finalIntent.add("example");
              // continue;
           }
           if (started_word_set.contains(intent.get(i).toLowerCase().trim())){
                finalIntent.add("gettingStarted");
               //continue;
           }
           if (reference_word_set.contains(intent.get(i).toLowerCase().trim())){
                finalIntent.add("completeReference");
                //continue;
           }
           if (trouble_word_set.contains(intent.get(i).toLowerCase().trim())){
                finalIntent.add("troubleShooting");
               // continue;
           }
           if (tutorial_word_set.contains(intent.get(i).toLowerCase().trim())){
                finalIntent.add("tutorials");
               //continue;
           }
        }
        if(finalIntent.isEmpty()){
             finalIntent.add("basics");
             return finalIntent;
        }
        else{
            return finalIntent;
        }
    }
    //intent = new ArrayList<>();
    @Override
    public TagOutput tagger(String lemma) {
        logger.info(lemma);
        taggedString = new ArrayList<>();

        concept = new ArrayList<>();
        intent = new ArrayList<>();
        CoreDocument coreDocument = new CoreDocument(lemma);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabels = coreDocument.tokens();
        int i = 0;
        for (CoreLabel coreLabel:coreLabels
             ) {
            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            if(pos.equals("NN") || pos.equals("NNS") || pos.equals("NNP")
                    || pos.equals("NNPS") || pos.equals("JJ")
                    || pos.equals("JJR") || pos.equals("JJS")) {

                concept.add(coreLabel.originalText());
                intent.add(coreLabel.originalText());
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
        System.out.println(finalConcept+ "before adding");
        System.out.println(finalIntent+"before adding intent");
        if(finalConcept.size()==finalIntent.size()){

        }else if(finalConcept.size()>finalIntent.size()){
            int c = finalConcept.size();
            int i1 = finalIntent.size();
            int k = c-i1;
            for(int j=0;j<k;j++){
                finalIntent.add("basics");
            }
        }
        else{
            int c = finalConcept.size();
            int i1 = finalIntent.size();
            int k= i1-c;
            for(int j=0;j<k;j++){
                finalConcept.add(finalConcept.get(c-1));
            }
        }

        //tagOutput.setTaggedConcept(finalConcept);
       // tagOutput.setTaggedLevel(finalIntent);

        TagOutput tagOutput = new TagOutput(finalConcept,finalIntent,rabbitMQListener.nlpModel.getUserId(),rabbitMQListener.nlpModel.getRole(),
                rabbitMQListener.nlpModel.getJwt(),rabbitMQListener.nlpModel.getSessionId());

        System.out.println("sending message to RabbitMQ toString: " + tagOutput);
       //TagOutput tagOutput =
        rabbitMQSender.sender(tagOutput);
        return tagOutput;
    }
}
