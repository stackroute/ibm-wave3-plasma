package com.stackroute.knowledgequeryservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Tag {
    private List<String> taggedConcept;
    private List<String> taggedLevel;
    private String userId;
    private String role;
    private String jwt;
    private String sessionId;

}