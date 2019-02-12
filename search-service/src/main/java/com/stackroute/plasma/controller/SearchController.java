package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.Search;
import com.stackroute.plasma.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SearchController {

    private SearchService searchService;
    ResponseEntity responseEntity;

    @Autowired
    public SearchController(SearchService searchService)
    {
        this.searchService= searchService;
    }

    @GetMapping("search")
    public ResponseEntity<?> getAllSearch()

    {
        return new ResponseEntity<List<Search>>(searchService.getAllSearch(),HttpStatus.OK);
    }

}
