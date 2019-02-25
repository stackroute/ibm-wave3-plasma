package com.stackroute.plasma.model;

import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;


//@Getter
@NodeEntity
public class Concept {
    @Id
    @GeneratedValue
    private long Id;
    @Property
    private String context;
    @Property
    private String name;
    @Property
    private String id;
    @Property
    private String type;
    @Property
    private String cLass;
    @Property
    private String parentid;
    @Property
    private String relation;

    @Relationship(type = "Details_of", direction = Relationship.INCOMING)
    private List<Relationship> relationship;

    public long getId() {
        return Id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Relationship> getRelationship() {
        return relationship;
    }

    public void setRelationship(List<Relationship> relationship) {
        this.relationship = relationship;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getcLass() {
        return cLass;
    }

    public void setcLass(String cLass) {
        this.cLass = cLass;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
