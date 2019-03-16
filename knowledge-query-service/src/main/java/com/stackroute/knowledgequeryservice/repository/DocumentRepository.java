package com.stackroute.knowledgequeryservice.repository;

import com.stackroute.knowledgequeryservice.model.Document;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends Neo4jRepository<Document,Long> {

    @Query("MATCH (d:Document) RETURN d")
    List<Document> getAll();

    /*@Query("MATCH (d)-[r:Document_of]->(c) " +
            "WHERE " +
            "d.concept={concept} and c.name={concept} and r.confidenceScore>0.2 and r.level={level} " +
            "RETURN d " +
            "ORDER BY r.confidenceScore DESC " +
            "LIMIT 10")*/
    @Query("MATCH (d)-[r:Document_of]->(c) " +
            "WHERE " +
            "d.concept={concept} and c.name={concept} and r.confidenceScore>0.2 and r.level={level} " +
            "RETURN distinct d.title " )
    List<Document> concept(@Param("concept") String concept, @Param("level") String level);
}
