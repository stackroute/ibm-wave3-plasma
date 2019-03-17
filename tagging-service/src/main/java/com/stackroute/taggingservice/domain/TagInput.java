package com.stackroute.taggingservice.domain;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class TagInput {

    private List<String> tokenizedQuery;
    private String userId;
    private String role;
    private String jwt;
}
