package com.stackroute.taggingservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NlpModel {
    @JsonProperty("tokenized_lematized")
    List<String> tokenized_lematized ;
    @JsonProperty("userId")
    String userId;
    @JsonProperty("jwt")
    String  jwt;
    @JsonProperty("role")
    String role;
    @JsonProperty("sessionId")
    String sessionId;
}
