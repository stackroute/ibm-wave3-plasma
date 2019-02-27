package com.stackroute.plasma.model;

import java.io.Serializable;
import java.util.List;

public class NlpModel implements Serializable {
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
}
