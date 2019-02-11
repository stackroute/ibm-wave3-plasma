package com.stackroute.plasma.searchservice.service;

import com.stackroute.plasma.searchservice.domain.Search;
import com.stackroute.plasma.searchservice.exception.SearchAlreadyExistException;

import java.util.List;

public class SearchServiceImpl implements SearchService{

    @Override
    public Search saveSearch(Search search) throws SearchAlreadyExistException {
        return null;
    }

    @Override
    public List<Search> getAllSearch() {
        return null;
    }

    @Override
    public Search FindByDomain(String domain) {
        return null;
    }
}
