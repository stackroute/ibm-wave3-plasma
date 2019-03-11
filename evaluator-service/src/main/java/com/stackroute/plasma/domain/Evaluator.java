package com.stackroute.plasma.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Timestamp;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evaluator {

    @JsonProperty("timestamp")
    private Timestamp timestamp;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("concept")
    private String concept;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("url")
    private String url;
    @JsonProperty("level")
    private String level;
    @JsonProperty("confidenceScore")
    private float confidenceScore;


    @Override
    public String toString() {
        return "Evaluator{" +
                "timestamp=" + timestamp +
                ", domain='" + domain + '\'' +
                ", concept='" + concept + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", keywords='" + keywords + '\'' +
                ", url='" + url + '\'' +
                ", level='" + level + '\'' +
                ", confidenceScore=" + confidenceScore +
                '}';
    }
}
