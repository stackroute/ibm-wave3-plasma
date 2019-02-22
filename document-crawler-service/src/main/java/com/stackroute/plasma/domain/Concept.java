package com.stackroute.plasma.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NodeEntity
public class Concept {

    @Id @GeneratedValue
    private long id;
    @Property
    private String domain;
    @Property
    private String concept;
    @Relationship(type = "Details_of", direction = Relationship.INCOMING)
    private Relationship relationship;
}
