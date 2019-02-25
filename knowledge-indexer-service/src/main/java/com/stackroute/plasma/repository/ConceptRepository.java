package com.stackroute.plasma.repository;


import com.stackroute.plasma.model.Concept;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface ConceptRepository extends Neo4jRepository<Concept,Long> {

    /* Reads the Concept node from  Domain Ontology */
    @Query("MATCH (c:DomainOntology) WHERE c.name={name} AND c.class=\"concept\" RETURN c")
    Concept getOneConcept(@Param("name") String name);
    //now the problem is I am not specifying the domain for searching the node which is important

}
