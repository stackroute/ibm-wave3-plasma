package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Description;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface DescriptionRepository extends Neo4jRepository<Description,Long> {

    /* Creates the description node */
    @Query("CREATE (d:Description) SET d.id={id}, d.timestamp={timestamp},d.concept={concept},d.domain={domain},d.description={description}," +
            "d.title={title},d.url={url},d.keywords={keywords} RETURN d")
    Description create(@Param("id") long id,
                       @Param("timestamp") String timestamp,
                       @Param("concept") String concept,
                       @Param("domain") String domain,
                       @Param("description") String description,
                       @Param("title") String title,
                       @Param("url") String url,
                       @Param("keywords") String keywords);

    /* Updates the description node */
    @Query("MATCH (d:Description) WHERE d.id={id} " +
            "SET d.id={id} SET d.timestamp={timestamp} SET d.concept={concept} SET d.domain={domain} SET d.description={description} SET" +
            "d.title={title} SET d.url={url} SET d.keywords={keywords} RETURN n")
    Description update(@Param("id") long id,
                       @Param("timestamp") String timestamp,
                       @Param("concept") String concept,
                       @Param("domain") String domain,
                       @Param("description") String description,
                       @Param("title") String title,
                       @Param("url") String url,
                       @Param("keywords") String keywords);

    /* Deletes the description node based on ID */
    @Query("MATCH (d:Description) WHERE d.id={id} DETACH DELETE d")
    Description delete(@Param("id") long id);  //by id

    /* Deletes the description node based on Timestamp */
    @Query("MATCH (d:Description) WHERE d.timestamp<{timestamp} DETACH DELETE d")
    Description delete(@Param("timestamp") Timestamp timestamp);  //by id

    /* Deletes all the description nodes for a particular concept */
    @Query("MATCH (d:Description) WHERE d.concept={concept} AND d.domain={domain} DETACH DELETE d")
    Description delete(@Param("concept") String concept,@Param("domain")String domain);  //by concept and domain

}
