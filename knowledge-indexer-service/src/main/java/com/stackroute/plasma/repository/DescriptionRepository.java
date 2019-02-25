package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Description;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface DescriptionRepository extends Neo4jRepository<Description,Long> {

    /* Creates the description node */
    @Query("CREATE (d:Description) SET d.id={id}, d.timestamp={timestamp},d.description={description}," +
            "d.title={title},d.url={url},d.keywords={keywords}")
    Description create(@Param("id") long id,@Param("timestamp") Timestamp timestamp,@Param("description") String description,
                       @Param("title") String title,@Param("url") String url,@Param("keywords") String keywords);

    /* Updates the description node */
    @Query("MATCH (d:Description) WHERE d.id={id} SET d.id={id}, d.timestamp={timestamp}, d.description={description}," +
            "d.title={title},d.url={url},d.keywords={keywords} RETURN n")
    Description update(@Param("id") long id,@Param("timestamp") Timestamp timestamp,@Param("description") String description,
                           @Param("title") String title,@Param("url") String url,@Param("keywords") String keywords);

    /* Deletes the description node */
    @Query("MATCH (d:Description) WHERE d.id={id} DETACH DELETE d")
    Description delete(@Param("id") long id);  //by id

    @Query("MATCH (d:Description) WHERE d.name={name} DETACH DELETE d")
    Description delete(@Param("name") String name);  //by name

}
