package com.stackroute.searchservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

 public class SearchOutput {

    @JsonProperty("timestamp")
    private Timestamp timestamp;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("concept")
    private String concept;
   @JsonProperty("urls")
    private String[] urls;


    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public SearchOutput(Timestamp timestamp, String domain, String concept, String[] urls) {
        this.timestamp = timestamp;
        this.domain = domain;
        this.concept = concept;
        this.urls = urls;
    }

    public SearchOutput() {
    }

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

}
