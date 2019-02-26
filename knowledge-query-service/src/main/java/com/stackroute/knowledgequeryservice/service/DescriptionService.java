package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Description;

import java.util.List;

public interface DescriptionService {
    public List<Description> getAll();
    public List<Description> concept(String concept,String level);
}
