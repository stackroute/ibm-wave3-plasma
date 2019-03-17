package com.stackroute.taggingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagOutput {

    private List<String> taggedConcept;
    private List<String> taggedLevel;
    private String userId;
    private String role;
    private String jwt;
    private String sessionId;

}