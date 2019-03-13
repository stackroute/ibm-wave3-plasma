package com.stackroute.taggingservice.domain;

import java.util.List;

public class TagInput {

    private List<String> tokenizedQuery;
    private String emailId;
    private String role;
    private String jwt;

    public TagInput() {
    }

    @Override
    public String toString() {
        return "TagInput{" +
                "tokenizedQuery=" + tokenizedQuery +
                ", emailId='" + emailId + '\'' +
                ", role='" + role + '\'' +
                ", jwt='" + jwt + '\'' +
                '}';
    }

    public List<String> getTokenizedQuery() {
        return tokenizedQuery;
    }

    public void setTokenizedQuery(List<String> tokenizedQuery) {
        this.tokenizedQuery = tokenizedQuery;
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

    public TagInput(List<String> tokenizedQuery, String emailId, String role, String jwt) {
        this.tokenizedQuery = tokenizedQuery;
        this.emailId = emailId;
        this.role = role;
        this.jwt = jwt;
    }
}
