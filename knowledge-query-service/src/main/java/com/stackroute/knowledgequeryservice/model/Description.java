package com.stackroute.knowledgequeryservice.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Getter
@Setter
@NodeEntity
public class Description {
    @Id
    @GeneratedValue
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
    /* @Property
     private String type;*/
}
