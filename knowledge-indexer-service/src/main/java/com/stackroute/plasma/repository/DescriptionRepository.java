package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Description;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface DescriptionRepository extends Neo4jRepository<Description,Long> {

    /* Creates the description node */
    @Query("CREATE (d:Description) SET d.id={id}, d.timestamp={timestamp},d.description={description},d.title={title},d.url={url},d.keywords={keywords}")
    Description create(@Param("id") long id,@Param("timestamp") Timestamp timestamp,@Param("description") String description,@Param("title")
                        String title,@Param("url") String url,@Param("keywords") String keywords);

    /* Updates the description node */
    @Query("MATCH (d:Description) WHERE d.id={id} SET d.id={id}, d.timestamp={timestamp},d.description={description},d.title={title},d.url={url},d.keywords={keywords} RETURN n")
    Description updateNode(@Param("id") long id,@Param("timestamp") Timestamp timestamp,@Param("description") String description,@Param("title")
            String title,@Param("url") String url,@Param("keywords") String keywords);

    /* Deletes the description node */


    /*
    @Query("MATCH (Node) RETURN Node")
    List<Node> getAllNodes();

    @Query("MATCH (n:Node) WHERE n.id={id} RETURN n")
    Node getOneNode(@Param("id") long id);   //by id

    @Query("MATCH (n:Node) WHERE n.name={name} RETURN n")
    Node getOneNode(@Param("name") String name); //by name

    @Query("CREATE (n:Node) SET n.id={id},n.name={name},n.parentId={parentId} RETURN n")
    Node createNode(long id,String name, long parentId);

    @Query("MATCH (n:Node) WHERE n.id={id} DETACH DELETE n RETURN n ")
    Node deleteNode(@Param("id") long id);  //by idid

    @Query("MATCH (n:Node) WHERE n.name={name} DETACH DELETE n RETURN n ")
    Node deleteNode(@Param("name") String name);  //by name

    @Query("MATCH (n:Node) WHERE n.id={id} SET n.name={name} SET n.parentId={parentId} RETURN n")
    Node updateNode(@Param("id") long id,@Param("name") String name,@Param("parentId") long parentId);
    */
}
