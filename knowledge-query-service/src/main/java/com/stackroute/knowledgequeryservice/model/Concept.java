package com.stackroute.knowledgequeryservice.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

//@Getter
@Setter
@NodeEntity
public class Concept {

    @Id
    @GeneratedValue
    private long Id;
    @Property
    private String name;
    @Property
    private String parentId;
    @Property
    private String type;
    @Property
    private String classs;
    @Property
    private String relation;
    @Property
    private String context;
    @Property
    private String id;

/*id: row.nodeid, name: row.name,  parentId: row.parentnodeid, type: row.nodetype,class:row.nodeclass,relation: row.parentRelation,context: row.context*/

    public long getId() {
        return Id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
