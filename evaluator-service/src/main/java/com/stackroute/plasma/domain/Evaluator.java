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
    private String title;
    private String description;
    private String keywords;
    @JsonProperty("url")
    private String url;
    @JsonProperty("level")
    private String level;
    @JsonProperty("confidenceScore")
    private long confidenceScore;


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

    public long getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(long confidenceScore) {
        this.confidenceScore = confidenceScore;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

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

