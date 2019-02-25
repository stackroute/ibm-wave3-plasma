package com.stackroute.cachemanagerservice.service;

import java.util.*;

import com.stackroute.cachemanagerservice.domain.Term;
import com.stackroute.cachemanagerservice.repository.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermService{

    @Autowired
    TermRepository termRepository;

    // @Override
    public List<Term> getAll() {
        return termRepository.getAllNodes();
    }


}
