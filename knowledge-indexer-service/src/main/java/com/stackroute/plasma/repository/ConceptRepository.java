package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Concept;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConceptRepository extends Neo4jRepository<Concept,Long> {

    @Query("match (n:DomainOntology) where n.type=\"concept\" return n")
    List<Concept> get();
}
