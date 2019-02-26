package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Concept;
import com.stackroute.knowledgequeryservice.repository.ConceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConceptServiceImpl implements ConceptService {

    @Autowired
    ConceptRepository conceptRepository;

    @Override
    public List<Concept> getAll() {
        return conceptRepository.getAll();
    }
}
