package com.stackroute.plasma.service;


import com.stackroute.plasma.model.Relationship;

import java.util.List;

public interface RelationshipService {
    //public List<Relationship> get();
    public void create(String concept, long confidenceScore, String level);
    public Relationship delete(String concept);
}
