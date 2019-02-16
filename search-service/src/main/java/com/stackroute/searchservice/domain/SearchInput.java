package com.stackroute.searchservice.domain;

public class SearchInput {
    private String domain;
    private String[] concepts;

    public SearchInput(String domain, String[] concepts) {
        this.domain = domain;
        this.concepts = concepts;
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

    public SearchInput() {
    }
}
