package com.stackroute.cachemanagerservice.controller;

import com.stackroute.cachemanagerservice.domain.Term;
import com.stackroute.cachemanagerservice.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TermController {

    @Autowired
    TermService termService;

    @GetMapping("getTerm")
    public List<Term> getAll(){
        return termService.getAll();
    }

}
