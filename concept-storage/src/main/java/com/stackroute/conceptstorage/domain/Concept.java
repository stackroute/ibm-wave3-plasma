package com.stackroute.conceptstorage.domain;

import org.apache.catalina.LifecycleState;

import java.util.List;

public class Concept {
    private String domain;
    private List<String> concept;

    public Concept(String domain, List<String> concept) {
        this.domain = domain;
        this.concept = concept;
    }

    public Concept() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<String> getConcept() {
        return concept;
    }

    public void setConcept(List<String> concept) {
        this.concept = concept;
    }
}
