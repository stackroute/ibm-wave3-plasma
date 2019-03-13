package com.stackroute.taggingservice.domain;

import java.util.List;

public class TagOutput {
    private List<String> taggedConcept;
    private List<String> taggedLevel;
    private String emailId;
    private String role;
    private String jwt;

    public TagOutput() {
    }

    public TagOutput(List<String> taggedConcept, List<String> taggedLevel, String emailId, String role, String jwt) {
        this.taggedConcept = taggedConcept;
        this.taggedLevel = taggedLevel;
        this.emailId = emailId;
        this.role = role;
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "TagOutput{" +
                "taggedConcept=" + taggedConcept +
                ", taggedLevel=" + taggedLevel +
                ", emailId='" + emailId + '\'' +
                ", role='" + role + '\'' +
                ", jwt='" + jwt + '\'' +
                '}';
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}