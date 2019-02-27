package com.stackroute.cachemanagerservice.domain;


import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type="counterIndicatorOf")
//@RelationshipEntity
public class Relationship {

    @Id @GeneratedValue
    private long id;

    @Property
    private int weight;

    private List<String> relationship = new ArrayList<>();

    @StartNode
    private Term term;

    @EndNode
    private Intent intent;

}