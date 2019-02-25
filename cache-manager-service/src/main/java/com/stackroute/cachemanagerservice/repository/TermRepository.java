package com.stackroute.cachemanagerservice.repository;

import com.stackroute.cachemanagerservice.domain.Term;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermRepository extends Neo4jRepository<Term,Long> {

    @Query("MATCH (Node) RETURN Node")
    List<Term> getAllNodes();
}