package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Concept;
import com.stackroute.plasma.model.Description;
import com.stackroute.plasma.repository.ConceptRepository;
import com.stackroute.plasma.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DescriptionImpl implements DescriptionService{

    @Autowired
    DescriptionRepository descriptionRepository;

    @Autowired
    ConceptRepository conceptRepository;

    @Override
    public List<Concept> getC(){return conceptRepository.get();}

    @Override
    public List<Description> getD(){return descriptionRepository.get();}

    @Override
    public Description create(Description description) {

        long id = description.getId();
        //Timestamp timestamp = description.getTimestamp();
        String timestamp = description.getTimestamp();
        String concept = description.getConcept();
        String domain = description.getDomain();
        String descript = description.getDescription();
        String title = description.getTitle();
        String url = description.getUrl();
        String keywords = description.getKeywords();
        return descriptionRepository.create(id,timestamp,concept,domain,descript,title,keywords,url);
    }

    @Override
    public Description update(Description description) {
        long id = description.getId();
        //Timestamp timestamp = description.getTimestamp();
        String timestamp = description.getTimestamp();
        String concept = description.getConcept();
        String domain = description.getDomain();
        String descript = description.getDescription();
        String title = description.getTitle();
        String url = description.getUrl();
        String keywords = description.getKeywords();
        return descriptionRepository.update(id,timestamp,concept,domain,descript,title,keywords,url);
    }

    @Override
    public Description delete(Timestamp timestamp) {
        return descriptionRepository.delete(timestamp);
    }

    @Override
    public Description delete(long id) {
        return descriptionRepository.delete(id);
    }

    @Override
    public Description delete(String concept, String domain) {
        return descriptionRepository.delete(concept,domain);
    }
}