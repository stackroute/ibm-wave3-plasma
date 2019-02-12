package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Search;
import com.stackroute.plasma.exception.SearchAlreadyExistException;


import java.util.List;

public class SearchServiceImpl implements SearchService {

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
