package com.stackroute.knowledgequeryservice.repository;

import com.stackroute.knowledgequeryservice.model.Description;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescriptionRepository extends Neo4jRepository<Description,Long> {

    @Query("MATCH (d:Description) RETURN d")
    List<Description> getAll();

}
