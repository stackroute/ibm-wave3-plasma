package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.controller.DescriptionController;
import com.stackroute.knowledgequeryservice.model.Description;
import com.stackroute.knowledgequeryservice.model.Descriptions;
import com.stackroute.knowledgequeryservice.repository.DescriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DescriptionServiceImpl implements DescriptionService {

    Logger logger = LoggerFactory.getLogger(DescriptionServiceImpl.class.getName());

    @Autowired
    DescriptionRepository descriptionRepository;


    @Override
    public List<Description> getAll() {
        return descriptionRepository.getAll();
    }

    @Override

    public List<List<Description>>
    concept(List<String> concepts, List<String> levels) {



        System.out.println(concepts);
        System.out.println(levels);
        int i;
        List<List<Description>>
                descriptions = new ArrayList<>();
         for (i = 0; i < concepts.size(); i++) {
                logger.info(concepts.get(i));
                logger.info(levels.get(i));
                descriptions.add(descriptionRepository.concept(concepts.get(i), levels.get(i)));
            }
            return descriptions;
        }
    }
