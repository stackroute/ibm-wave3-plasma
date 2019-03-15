package com.stackroute.conceptstorage.controller;

import com.stackroute.conceptstorage.service.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ConceptController {
    @Autowired
    ConceptService conceptService;

    @GetMapping("/concept")
    ResponseEntity<?> getConcept(){
        return new ResponseEntity<>(conceptService.getConcept(), HttpStatus.OK);
    }
}

