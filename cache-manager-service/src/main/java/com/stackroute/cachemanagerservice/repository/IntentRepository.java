package com.stackroute.cachemanagerservice.repository;

import com.stackroute.cachemanagerservice.domain.Intent;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntentRepository extends Neo4jRepository<Intent,Long> {

    @Query("MATCH (Intent) RETURN Intent")
    List<Intent> getAllNodes();
}
