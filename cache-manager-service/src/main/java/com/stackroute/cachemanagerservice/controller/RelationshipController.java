package com.stackroute.cachemanagerservice.controller;


import com.stackroute.cachemanagerservice.domain.Relationship;
import com.stackroute.cachemanagerservice.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RelationshipController {
    @Autowired
    RelationshipService relationshipService;

    @GetMapping("get")
    public List<Relationship> getAll(){
        return relationshipService.getAll();
    }

}
