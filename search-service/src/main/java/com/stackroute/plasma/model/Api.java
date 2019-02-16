package com.stackroute.plasma.model;

public class Api {
    //final static String apiKey = "AIzaSyB-93tpPyxrK76l6iw-mFnsvDiUJCLpFw8";
    //final static String customSearchEngineKey = "006477474756235376421:nz2modhy5qa";

    // base url for the search query
    //final static String searchURL = "https://www.googleapis.com/customsearch/v1?";
    private String domain = "java";
    private  String[] concepts = {"encapsulation","abstraction"};

    public Api(String domain, String[] concepts) {
        this.domain = domain;
        this.concepts = concepts;
    }

    public Api() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String[] getConcepts() {
        return concepts;
    }

    public void setConcepts(String[] concepts) {
        this.concepts = concepts;
    }
}
