package com.stackroute.plasma.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.sql.Timestamp;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Url.class)
public class Url {

    @JsonProperty("url")
    private String url;
    @JsonProperty("concept")
    private String concept;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("doc")
    private String doc;
    @JsonProperty("timestamp")
    private Timestamp timestamp;


}