package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Description;
import com.stackroute.knowledgequeryservice.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionServiceImpl implements DescriptionService {

    @Autowired
    DescriptionRepository descriptionRepository;

    @Override
    public List<Description> getAll() {
        return descriptionRepository.getAll();
    }

    @Override
    public List<Description> concept(String concept, String level) {
        /*return descriptionRepository.concept("Erlang","basics");*/
        return descriptionRepository.concept(concept,level);
    }
}
