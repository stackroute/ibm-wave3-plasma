package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Search;
import com.stackroute.plasma.exception.SearchAlreadyExistException;

import java.util.List;

public interface SearchService {
    public Search saveSearch(Search search) throws SearchAlreadyExistException;
    public List<Search> getAllSearch();
    public Search FindByDomain(String domain);

}
