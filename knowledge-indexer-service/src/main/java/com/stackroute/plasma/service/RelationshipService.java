package com.stackroute.plasma.service;


import com.stackroute.plasma.model.Relationship;


public interface RelationshipService {
    public void create(String concept, long confidenceScore, String level);
    public Relationship delete(String concept);
}
