package com.stackroute.knowledgequeryservice.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
public class Document {

    @Id @GeneratedValue
    private long id;
    @Property
    private String timestamp;
    @Property
    private String concept;
    @Property
    private String domain;
    @Property
    private String description;
    @Property
    private String title;
    @Property
    private String url;
    @Property
    private String keywords;
    @Property
    private String level;
    @Property
    private float confidenceScore;


}
