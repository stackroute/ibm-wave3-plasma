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
/*n.id = i.id, n.name = i.name, n.parentId = i.parentId, n.type = i.type, n.Class = i.Class, n.relation = i.relation,  n.context = i.context*/
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
    /*@Property
    private String id;*/

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getParentId() {
        return parentId;
    }

    public String getType() {
        return type;
    }

    public String getClasss() {
        return classs;
    }

    public String getRelation() {
        return relation;
    }

    public String getContext() {
        return context;
    }
}
