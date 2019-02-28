package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Description;

import java.util.List;

public interface DescriptionService {
    public List<Description> getAll();
    public List<List<Description>> concept(List<String> concepts,List<String> levels);
}
