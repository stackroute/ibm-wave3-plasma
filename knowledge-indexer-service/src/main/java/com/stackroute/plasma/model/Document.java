package com.stackroute.plasma.model;

import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//@Getter
@NodeEntity
public class Document {

    @Id @GeneratedValue
    private long id;
    @Property
    private String timestamp;
    @Property
    private String concept;
    @Property
    private String domain;
    @Property
    private String description;
    @Property
    private String title;
    @Property
    private String url;
    @Property
    private String keywords;
    /* @Property
    private String type;*/

    /*@Relationship(type = "Details_of", direction = Relationship.OUTGOING)
    private Concept parent;*/
    /*@Relationship(type = "Details_of", direction = Relationship.OUTGOING)
    private List<Concept> parent = new ArrayList<>();*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}
