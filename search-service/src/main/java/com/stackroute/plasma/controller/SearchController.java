package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.Search;
import com.stackroute.plasma.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private SearchService searchService;
    ResponseEntity responseEntity;

    @Autowired
    public SearchController(SearchService searchService)
    {
        this.searchService= searchService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "java")

    @ResponseBody
    public String  getDomainName() {
        return Search.getAllUrls();

    }
}
