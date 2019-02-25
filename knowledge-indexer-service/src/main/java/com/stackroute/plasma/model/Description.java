package com.stackroute.plasma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NodeEntity
public class Description {

    @Id @GeneratedValue
    private long id;
    @Property
    private Timestamp timestamp;
    @Property
    private String description;
    @Property
    private String title;
    @Property
    private String url;
    @Property
    private String keywords;
    @Relationship(type = "Details_of", direction = Relationship.OUTGOING)
    private Concept parent;

}
