package com.stackroute.cachemanagerservice.domain;

import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Intent {

    @Id //@GeneratedValue
    private long Id;

    @Property
    private String name;

    @Property
    private String weight;

    @Property
    private String id;

    @Property
    private String type;

    @Property
    private String parenttype;

    @Property
    private String parentid;

    @Property
    private String relation;

    @Relationship(type = "counterIndicatorOf", direction = Relationship.INCOMING)
    private List<Relationship> relationship;

    public long getId() {
        return Id;
    /*@Relationship(type = "counterIndicatorOf", direction = Relationship.INCOMING)
    private List<Relationship> relationship;*/

//    public long getId() {
//        return Id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getParenttype() {
//        return parenttype;
//    }
//
//    public String getParentid() {
//        return parentid;
//    }
//
//    public String getRelation() {
//        return relation;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getParenttype() {
//        return parenttype;
//    }
//
//    public String getParentid() {
//        return parentid;
//    }
//
//    public String getRelation() {
//        return relation;
//    }
//
//    public String getWeight() {
//        return weight;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getWeight() {
//        return weight;
//    }
    }
}