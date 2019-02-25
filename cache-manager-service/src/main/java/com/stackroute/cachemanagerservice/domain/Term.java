package com.stackroute.cachemanagerservice.domain;

import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.Relationship;
import java.util.ArrayList;
import java.util.List;

//@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Term {

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

    @Relationship(type = "counterIndicatorOf", direction = Relationship.OUTGOING)
    private List<Intent> intent = new ArrayList<>();

    public List<Intent> getIntent() {
        return intent;
    }

    public long getId() {
        return Id;
    }

    public String getType() {
        return type;
    }

    public String getParenttype() {
        return parenttype;
    }

    public String getParentid() {
        return parentid;
    }

    public String getRelation() {
        return relation;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }
}
