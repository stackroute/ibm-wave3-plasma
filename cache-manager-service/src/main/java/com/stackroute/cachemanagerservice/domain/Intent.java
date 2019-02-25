package com.stackroute.cachemanagerservice.domain;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Intent {

    @Id //@GeneratedValue
    private long id;

    @Property
    private String name;

    @Relationship(type = "CHILD_OF", direction = Relationship.INCOMING)
    private List<Relationship> relationship;
    //private Relationship relationship;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Relationship> getRelationship() {
        return relationship;
    }
}