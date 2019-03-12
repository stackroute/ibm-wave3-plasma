package com.stackroute.taggingservice.domain;

import java.util.List;

public class TagInput {

    private List<String> tokenizedQuery;
    private String userId;
    private String role;
    private String jwt;

    public TagInput(List<String> tokenizedQuery, String userId, String role, String jwt) {
        this.tokenizedQuery = tokenizedQuery;
        this.userId = userId;
        this.role = role;
        this.jwt = jwt;
    }

    public TagInput() {
    }

    public List<String> getTokenizedQuery() {
        return tokenizedQuery;
    }

    public void setTokenizedQuery(List<String> tokenizedQuery) {
        this.tokenizedQuery = tokenizedQuery;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "TagInput{" +
                "tokenizedQuery=" + tokenizedQuery +
                ", userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                ", jwt='" + jwt + '\'' +
                '}';
    }
}
