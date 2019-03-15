package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Relationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface RelationshipRespository extends Neo4jRepository<Relationship,Long> {

    /* Creates the relationship from description node to concept node */
    @Query("MATCH (c:Concept),(d:Document) " +
            "WHERE c.name={concept} AND d.concept={concept} AND d.url={url}"+// AND d.timestamp={timestamp}" + //AND c.name = d.concept AND c.type = \"concept\" " +
            "MERGE (d)-[r:Document_of { confidenceScore:{confidenceScore},level:{level} }]->(c) RETURN r")
    void create(@Param("concept")String concept,@Param("confidenceScore")float confidenceScore, @Param("level")String level,@Param("url") String url);

    /* Reads the Concept node from  Domain Ontology */
    //@Query("MATCH (c:DomainOntology) WHERE c.name={name} AND c.class=\"concept\" RETURN c")
    //String getOneConcept(@Param("name") String name);
    //now the problem is I am not specifying the domain for searching the node which is important


    /* Deletes the relationship from description node to concept node */
    @Query("MATCH (d)-[r:Document_of]->(c) WHERE d.concept={concept} DETACH DELETE r RETURN r")
    Relationship delete(@Param("concept") String concept);

}








