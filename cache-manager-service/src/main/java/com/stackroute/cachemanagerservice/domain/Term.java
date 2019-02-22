package com.stackroute.cachemanagerservice.domain;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.Relationship;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Term {

    @Id //@GeneratedValue
    private long id;

    @Property
    private String name;

    @Property
    private long parentId;

    @Relationship(type = "CHILD_OF", direction = Relationship.OUTGOING)
    private List<Intent> intent = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getParentId() {
        return parentId;
    }

    public List<Intent> getIntent() {
        return intent;
    }

}
