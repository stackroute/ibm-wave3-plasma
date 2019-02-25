package com.stackroute.cachemanagerservice.repository;

import com.stackroute.cachemanagerservice.domain.Intent;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntentRepository extends Neo4jRepository<Intent,Long> {

    @Query("MATCH (n:Intent) where n.type={intent} RETURN n")
    List<Intent> intent(@Param("intent") String intent);

}
