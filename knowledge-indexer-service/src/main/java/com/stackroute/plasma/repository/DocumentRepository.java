package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Document;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends Neo4jRepository<Document,Long> {

    @Query("match(c:Concept{name:{concept}}) merge(d:Document{timestamp:{timestamp},concept:{concept},domain:{domain},description:{description},title:{title},url:{url},keywords:{keywords} })-[r:Document_of {level: {level},confidenceScore: {confidenceScore}}]->(c) return d")
    Document create(@Param("timestamp") String timestamp,
                    @Param("domain") String domain,
                    @Param("concept") String concept,
                    @Param("title") String title,
                    @Param("description") String description,
                    @Param("keywords") String keywords,
                    @Param("url") String url,
                    @Param("level")String level,
                    @Param("confidenceScore")long confidenceScore);

}
