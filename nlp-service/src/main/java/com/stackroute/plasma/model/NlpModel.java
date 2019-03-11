package com.stackroute.plasma.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NlpModel {
    @JsonProperty("tokenized_lematized")
    List<String> tokenized_lematized ;

    public List<String> getTokenized_lematized() {
        return tokenized_lematized;
    }

    public void setTokenized_lematized(List<String> tokenized_lematized) {
        this.tokenized_lematized = tokenized_lematized;
    }

    public NlpModel(List<String> tokenized_lematized) {
        this.tokenized_lematized = tokenized_lematized;
    }

    public NlpModel() {
    }

    @Override
    public String toString() {
        return "NlpModel{" +
                "tokenized_lematized=" + tokenized_lematized +
                '}';
    }
}
