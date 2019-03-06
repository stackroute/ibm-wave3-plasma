package com.stackroute.knowledgequeryservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Tag {

    
    //private String domain;
    private List<String> taggedConcept;
    private List<String> taggedLevel;

}