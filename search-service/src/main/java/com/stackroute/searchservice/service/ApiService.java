package com.stackroute.searchservice.service;

import org.springframework.stereotype.Service;


public interface ApiService {
    public String[] getConceptsUrl(String qSearch, int start, int numOfResults);
}
