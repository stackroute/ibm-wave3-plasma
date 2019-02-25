package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Relationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface RelationshipRespository extends Neo4jRepository<Relationship,Long> {

    /* Creates the relationship from description node to concept node */
    @Query("MATCH (c:Concept),(d:Description) WHERE c.concept CREATE x=(n)-[r:CHILD_OF]->(p) RETURN r")
    Relationship create();

    /* Updates the relationship from description node to concept node */
    @Query("MATCH ()-[r]->() WHERE relationship(r)= 0 RETURN r ")
    Relationship update();//@Param("id") long id);

    /* Deletes the relationship from description node to concept node */
    @Query("MATCH (n:Node)-[r]->(p:Parent) WHERE r.id={id} DETACH DELETE r RETURN r.id,r.node,r.parent ")
    Relationship delete(@Param("id") long id);      //return type Relationship(for good practice)

}
