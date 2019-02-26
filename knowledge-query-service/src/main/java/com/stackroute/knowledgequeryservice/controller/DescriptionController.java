package com.stackroute.knowledgequeryservice.controller;

import com.stackroute.knowledgequeryservice.model.Description;
import com.stackroute.knowledgequeryservice.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class DescriptionController {
    @Autowired
    DescriptionService descriptionService;

    @GetMapping("get")
    public List<Description> getAll(){
        return descriptionService.getAll();
    }

    @GetMapping("get/{concept}/{level}")
    public List<Description> concept(@PathVariable("concept") String concept,@PathVariable("level") String level){
        return descriptionService.concept(concept,level);
    }
}
