package com.stackroute.plasma.searchservice.service;

import com.stackroute.plasma.searchservice.domain.Search;
import com.stackroute.plasma.searchservice.exception.SearchAlreadyExistException;
import com.stackroute.plasma.searchservice.exception.SearchNotFoundException;

import java.util.List;

public interface SearchService {
    public Search saveSearch(Search search) throws SearchAlreadyExistException;
    public List<Search> getAllSearch();
    public Search FindByDomain(String domain);

}
