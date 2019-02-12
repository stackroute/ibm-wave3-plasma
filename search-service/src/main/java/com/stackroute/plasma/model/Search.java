package com.stackroute.plasma.model;

import java.util.Arrays;

public class Search {
    private String domainName;
    private String[] concepts;

    public Search(String domainName, String[] concepts) {
        this.domainName = domainName;
        this.concepts = concepts;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String[] getConcepts() {
        return concepts;
    }

    public void setConcepts(String[] concepts) {
        this.concepts = concepts;
    }

    public static String getAllUrls() {
        return null;
    }

    @Override
    public String toString() {
        return "Search{" +
                "domainName='" + domainName + '\'' +
                ", concepts=" + Arrays.toString(concepts) +
                '}';
    }

}
