package com.stackroute.taggingservice.config;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PipelineConfig {
    private static Properties properties;
    private static String propertiesName = "tokenize, ssplit, pos, lemma";
    private  static StanfordCoreNLP stanfordCoreNLP;


    public PipelineConfig() {
    }

    static {
        properties = new Properties();
        properties.setProperty("annotators",propertiesName);
    }

    @Bean(name = "stanfordCoreNLP")
    public static StanfordCoreNLP getPipeline(){
        if(stanfordCoreNLP == null){
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }

}
