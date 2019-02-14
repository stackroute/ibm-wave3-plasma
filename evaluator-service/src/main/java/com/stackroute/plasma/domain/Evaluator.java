package com.stackroute.plasma.domain;


import lombok.*;

import javax.swing.text.Element;
import java.sql.Timestamp;


@Data
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Evaluator {

    private Timestamp timestamp;
    private String domain;
    private String concept;
    private String url;
    private String level;
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

