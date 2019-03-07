package com.stackroute.plasma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Data
@NodeEntity
public class Document {

    @JsonProperty("timestamp")
    @Id
    private String timestamp;
    @JsonProperty("domain")
    @Property
    private String domain;
    @JsonProperty("concept")
    @Property
    private String concept;
    @JsonProperty("title")
    @Property
    private String title;
    @JsonProperty("description")
    @Property
    private String description;
    @JsonProperty("keywords")
    @Property
    private String keywords;
    @JsonProperty("url")
    @Property
    private String url;
    @JsonProperty("level")
    @Property
    private String level;
    @JsonProperty("confidenceScore")
    @Property
    private long confidenceScore;


    @Override
    public String toString() {
        return "Document{" +
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

