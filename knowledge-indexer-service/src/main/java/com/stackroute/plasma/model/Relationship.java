package com.stackroute.plasma.model;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "Document_of")
public class Relationship {

    @Id @GeneratedValue
    private long id;
    @Property
    private String level;
    @Property
    private float confidenceScore;

}
