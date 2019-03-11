package com.stackroute.searchservice.service;


import com.stackroute.searchservice.domain.SearchStorage;

public interface ApiService {
    public SearchStorage save(SearchStorage searchStorage);
    public String[] getConceptsUrl(String qSearch, int start, int numOfResults);
}
