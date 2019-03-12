package com.stackroute.plasma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class NlpModel {
    @JsonProperty("tokenized_lematized")
    List<String> tokenized_lematized ;
    String userId;
    String  jwt;
    String role;

    public NlpModel(List<String> tokenized_lematized, String userId, String jwt, String role) {
        this.tokenized_lematized = tokenized_lematized;
        this.userId = userId;
        this.jwt = jwt;
        this.role = role;
    }

    public NlpModel() {
    }

    public List<String> getTokenized_lematized() {
        return tokenized_lematized;
    }

    public void setTokenized_lematized(List<String> tokenized_lematized) {
        this.tokenized_lematized = tokenized_lematized;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "NlpModel{" +
                "tokenized_lematized=" + tokenized_lematized +
                ", userId='" + userId + '\'' +
                ", jwt='" + jwt + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
