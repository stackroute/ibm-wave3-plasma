package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.Relationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RelationshipRespository extends Neo4jRepository<Relationship,Long> {

    /* Creates the relationship from description node to concept node */

    /* Updates the relationship from description node to concept node */

    /* Deletes the relationship from description node to concept node */

}
