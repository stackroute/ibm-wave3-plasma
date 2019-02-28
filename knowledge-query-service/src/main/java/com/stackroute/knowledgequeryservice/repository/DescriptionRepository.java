package com.stackroute.knowledgequeryservice.repository;

import com.stackroute.knowledgequeryservice.model.Description;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescriptionRepository extends Neo4jRepository<Description,Long> {

    @Query("MATCH (d:Description) RETURN d")
    List<Description> getAll();

    @Query("MATCH (d)-[r:Details_of]->(c) " +
            "WHERE " +
            "d.concept={concept} and c.name={concept} and r.confidenceScore>80 and r.level={level} " +
            "RETURN d " +
            "ORDER BY r.confidenceScore DESC " +
            "LIMIT 10")
    List<Description> concept(@Param("concept") String concept,@Param("level") String level);

}
