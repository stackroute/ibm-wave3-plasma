package com.stackroute.plasma.model;

import lombok.Getter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@Getter
@NodeEntity
public class Concept {

    @Id
    private long id;
    @Property
    private String domain;
    @Property
    private String concept;

    @Relationship(type = "Details_of", direction = Relationship.INCOMING)
    private Relationship relationship;

}
