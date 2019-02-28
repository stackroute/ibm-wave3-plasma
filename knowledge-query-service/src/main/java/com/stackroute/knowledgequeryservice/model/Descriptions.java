package com.stackroute.knowledgequeryservice.model;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.util.List;


@Data
public class Descriptions {
    String userId;
    List<List<Description>> descriptions;
}
