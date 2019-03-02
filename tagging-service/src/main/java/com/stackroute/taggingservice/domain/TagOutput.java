package com.stackroute.taggingservice.domain;

import java.util.List;

public class TagOutput {
    private List<String> taggedConcept;
    private List<String> taggedLevel;

    public TagOutput(List<String> taggedConcept, List<String> taggedLevel) {
        this.taggedConcept = taggedConcept;
        this.taggedLevel = taggedLevel;
    }

    public TagOutput() {
    }

    public List<String> getTaggedConcept() {
        return taggedConcept;
    }

    public void setTaggedConcept(List<String> taggedConcept) {
        this.taggedConcept = taggedConcept;
    }

    public List<String> getTaggedLevel() {
        return taggedLevel;
    }

    public void setTaggedLevel(List<String> taggedLevel) {
        this.taggedLevel = taggedLevel;
    }

    @Override
    public String toString() {
        return "TagOutput{" +
                "taggedConcept=" + taggedConcept +
                ", taggedLevel=" + taggedLevel +
                '}';
    }
}