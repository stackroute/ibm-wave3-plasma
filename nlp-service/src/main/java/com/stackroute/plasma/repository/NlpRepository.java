package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.UserQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NlpRepository extends MongoRepository<UserQuery,Integer> {

}
