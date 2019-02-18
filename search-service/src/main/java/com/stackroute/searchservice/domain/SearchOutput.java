package com.stackroute.searchservice.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SearchOutput {

    private Timestamp timestamp;
    private String domain;
    private String concept;
   // private List<String[]> urls;
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

//url object sent

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
