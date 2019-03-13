package com.stackroute.taggingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TagOutput {

    private List<String> taggedConcept;
    private List<String> taggedLevel;
    private String userId;
    private String role;
    private String jwt;

}