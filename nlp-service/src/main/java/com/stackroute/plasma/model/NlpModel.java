package com.stackroute.plasma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NlpModel {
    @JsonProperty("tokenized_lematized")
    List<String> tokenized_lematized ;
    String userId;
    String  jwt;
    String role;
    String sessionId;
}
