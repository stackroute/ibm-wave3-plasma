package com.stackroute.taggingservice.domain;

import java.util.List;

public class TagOutput {
    private List<String> taggedConcept;
    private List<String> taggedLevel;
    private String userId;
    private String role;
    private String jwt;

    public TagOutput(List<String> taggedConcept, List<String> taggedLevel, String userId, String role, String jwt) {
        this.taggedConcept = taggedConcept;
        this.taggedLevel = taggedLevel;
        this.userId = userId;
        this.role = role;
        this.jwt = jwt;
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
        return "TagOutput{" +
                "taggedConcept=" + taggedConcept +
                ", taggedLevel=" + taggedLevel +
                ", userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                ", jwt='" + jwt + '\'' +
                '}';
    }
}