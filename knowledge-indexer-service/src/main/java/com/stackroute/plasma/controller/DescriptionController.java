package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.Description;
import com.stackroute.plasma.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;


@RestController
@RequestMapping("api/v1")
public class DescriptionController {

    @Autowired
    DescriptionService descriptionService;

    @PostMapping("/create")
    public Description create(@RequestBody Description description){
        return descriptionService.create(description);
    }

    @PutMapping("/update")
    public Description update(@RequestBody Description description)
    {
        return descriptionService.update(description);
    }

    @DeleteMapping("/delete/id/{id}")
    public Description delete(@PathVariable("id") long id) { return descriptionService.delete(id); }

    @DeleteMapping("/delete/time/{timestamp}")
    public Description delete(@PathVariable("timestamp") Timestamp timestamp) { return descriptionService.delete(timestamp);}

}
