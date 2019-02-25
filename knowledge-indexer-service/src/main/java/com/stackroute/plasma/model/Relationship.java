package com.stackroute.plasma.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "Details_of")
public class Relationship {

    @Id @GeneratedValue
    private long id;

    @Property
    private String level;
    @Property
    private long confidenceScore;

    @StartNode
    private Description description;
    @EndNode
    private Concept concept;

}
