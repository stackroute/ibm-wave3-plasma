package com.stackroute.plasma.service;


import com.stackroute.plasma.model.Relationship;

public interface RelationshipService {
    public void create(String concept, float confidenceScore, String level, String url,String timestamp);
    public Relationship delete(String concept);
}
