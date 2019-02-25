package com.stackroute.cachemanagerservice.service;

import com.stackroute.cachemanagerservice.domain.Intent;
import com.stackroute.cachemanagerservice.domain.Term;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CrudService {

    public List<Term> getAll();

    public Collection<Intent> graph();

}