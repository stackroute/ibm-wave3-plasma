package com.stackroute.cachemanagerservice.service;

import com.stackroute.cachemanagerservice.domain.Relationship;
import com.stackroute.cachemanagerservice.repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RelationshipService {

    @Autowired
    RelationshipRepository relationshipRepository;

    public List<Relationship> getAll(){
        return relationshipRepository.getAllRelations();
    }


}