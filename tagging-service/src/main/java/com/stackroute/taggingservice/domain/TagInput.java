package com.stackroute.taggingservice.domain;

import java.util.List;

public class TagInput {

    private List<String> tokenizedQuery;

    public TagInput(List<String> tokenizedQuery) {
        this.tokenizedQuery = tokenizedQuery;
    }

    public TagInput() {
    }

    public List<String> getTokenizedQuery() {
        return tokenizedQuery;
    }

    public void setTokenizedQuery(List<String> tokenizedQuery) {
        this.tokenizedQuery = tokenizedQuery;
    }

    @Override
    public String toString() {
        return "TagInput{" +
                "tokenizedQuery=" + tokenizedQuery +
                '}';
    }
}
