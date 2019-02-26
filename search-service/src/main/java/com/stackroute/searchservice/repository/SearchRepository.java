package com.stackroute.searchservice.repository;

import com.stackroute.searchservice.domain.SearchStorage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends MongoRepository<SearchStorage,String> {

}
