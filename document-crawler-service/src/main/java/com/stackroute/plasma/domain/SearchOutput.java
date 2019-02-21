package com.stackroute.plasma.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = SearchOutput.class)
public class SearchOutput {

    @JsonProperty("timestamp")
    private Timestamp timestamp;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("concept")
    private String concept;
    // private List<String[]> urls;
    @JsonProperty("urls")
    private String[] urls;


    public SearchOutput() {

    }
    public SearchOutput(Timestamp timestamp, String domain, String concept, String[] urls) {
        this.timestamp = timestamp;
        this.domain = domain;
        this.concept = concept;
        this.urls = urls;
    }

//url object sent


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }




}
