package com.stackroute.cachemanagerservice.controller;

import com.stackroute.cachemanagerservice.domain.Intent;
import com.stackroute.cachemanagerservice.service.IntentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class IntentController {

    @Autowired
    IntentService intentService;

    @GetMapping("getIntent")
    public List<Intent> getAll(){
        return intentService.getAll();
    }
    /*@GetMapping("getIntent")
    public Intent getAll(){
        return intentService.getAll();
    }*/

  /*  @GetMapping("post")
    public Intent create(){return intentService.create();}*/
}
