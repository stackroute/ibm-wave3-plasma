package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Document;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends Neo4jRepository<Document,Long> {

    /* Creates the description node */
    @Query("merge (d:Document) SET d.timestamp={timestamp},d.concept={concept},d.domain={domain},d.description={description}," +
            "d.title={title},d.url={url},d.keywords={keywords},d.level={level},d.confidenceScore={confidenceScore} RETURN d")
    Document create(//@Param("id") long id,
                    @Param("timestamp") String timestamp,
                    @Param("concept") String concept,
                    @Param("domain") String domain,
                    @Param("description") String description,
                    @Param("title") String title,
                    @Param("keywords") String keywords,
                    @Param("url") String url,
                    @Param("level")String level,
                    @Param("confidenceScore")float confidenceScore);

    /* Updates the description node */
    @Query("MATCH (d:Document) WHERE d.id={id} " +
            "SET d.id={id} SET d.timestamp={timestamp} SET d.concept={concept} SET d.domain={domain} SET d.description={description} SET" +
            "d.title={title} SET d.url={url} SET d.keywords={keywords} RETURN d")
    Document update(@Param("id") long id,
                    @Param("timestamp") String timestamp,
                    @Param("concept") String concept,
                    @Param("domain") String domain,
                    @Param("description") String description,
                    @Param("title") String title,
                    @Param("url") String url,
                    @Param("keywords") String keywords);

    /* Deletes the description node based on ID */
    @Query("MATCH (d:Document) WHERE d.id={id} DETACH DELETE d")
    Document delete(@Param("id") long id);  //by id

    /* Deletes the description node based on Timestamp */
    @Query("MATCH (d:Document) WHERE d.timestamp<{timestamp} DETACH DELETE d")
    Document delete(@Param("timestamp") String timestamp);  //by id

    /* Deletes all the description nodes for a particular concept */
    @Query("MATCH (d:Document) WHERE d.concept={concept} AND d.domain={domain} DETACH DELETE d")
    Document delete(@Param("concept") String concept, @Param("domain")String domain);  //by concept and domain

}
