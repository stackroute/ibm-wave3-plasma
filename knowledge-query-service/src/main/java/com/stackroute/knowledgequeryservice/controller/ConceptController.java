package com.stackroute.knowledgequeryservice.controller;

import com.stackroute.knowledgequeryservice.model.Concept;
import com.stackroute.knowledgequeryservice.service.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/")
public class ConceptController {
    @Autowired
    ConceptService conceptService;

    @GetMapping("get")
    public List<Concept> getAll(){
       return conceptService.getAll();
    }
}
