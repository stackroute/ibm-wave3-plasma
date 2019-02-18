package com.stackroute.plasma.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.swing.text.Element;
import java.sql.Timestamp;


@Data
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Url.class)
public class Evaluator {

    @JsonProperty("timestamp")
    private Timestamp timestamp;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("concept")
    private String concept;
    @JsonProperty("url")
    private String url;
    @JsonProperty("level")
    private String level;
    @JsonProperty("confidenceScore")
    private int confidenceScore;


    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(int confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    @Override
    public String toString() {
        return "Evaluator{" +
                "url='" + url + '\'' +
                ", concept='" + concept + '\'' +
                ", domain='" + domain + '\'' +
                ", level=" + level +
                ", timestamp=" + timestamp +
                ", confidenceScore=" + confidenceScore +
                '}';
    }

}

