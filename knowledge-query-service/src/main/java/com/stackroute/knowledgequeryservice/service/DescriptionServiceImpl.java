package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Description;
import com.stackroute.knowledgequeryservice.model.Descriptions;
import com.stackroute.knowledgequeryservice.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<List<Description>> concept(List<String> concepts, List<String> levels) {
        /*return descriptionRepository.concept("Erlang","basics");*/
        //return descriptionRepository.concept(concept,level);
        //List<Description> descriptions = new ArrayList<>();

        System.out.println(concepts);
        System.out.println(levels);
        int i; List<List<Description>> descriptions = new ArrayList<>();
        for (i = 0; i < concepts.size(); i++) {
            System.out.println(concepts.get(i));
            System.out.println(levels.get(i));
            descriptions.add(descriptionRepository.concept(concepts.get(i),levels.get(i)));
        }
        return descriptions;
    }
}
