package com.stackroute.plasma.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = SearchOutput.class)
public class SearchOutput {

    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("concept")
    private String concept;
    @JsonProperty("urls")
    private String[] urls;


    public SearchOutput() {

    }
    public SearchOutput(String timestamp, String domain, String concept, String[] urls) {
        this.timestamp = timestamp;
        this.domain = domain;
        this.concept = concept;
        this.urls = urls;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
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


    @Override
    public String toString() {
        return "SearchOutput{" +
                "timestamp=" + timestamp +
                ", domain='" + domain + '\'' +
                ", concept='" + concept + '\'' +
                ", urls=" + Arrays.toString(urls) +
                '}';
    }
}
