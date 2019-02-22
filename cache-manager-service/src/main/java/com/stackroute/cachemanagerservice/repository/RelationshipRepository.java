package com.stackroute.cachemanagerservice.repository;

import com.stackroute.cachemanagerservice.domain.Relationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface RelationshipRepository extends Neo4jRepository<Relationship,Long> {

    @Query("MATCH p=()-[r:CHILD_OF]->() RETURN p")
    List<Relationship> getAllRelations();

}

