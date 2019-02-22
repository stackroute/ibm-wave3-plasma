package com.stackroute.plasma.repository;


import com.stackroute.plasma.model.Concept;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ConceptRepository extends Neo4jRepository<Concept,Long> {

    /* Finds the Concept node from  Domain Ontology */

    /* Reads the Concept node from  Domain Ontology */

}
