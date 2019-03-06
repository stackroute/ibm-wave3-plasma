package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Description;
import com.stackroute.plasma.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DescriptionImpl implements DescriptionService{

    @Autowired
    DescriptionRepository descriptionRepository;

    @Override
    public Description create(Description description) {

        long id = description.getId();
        String timestamp = description.getTimestamp();
        String concept = description.getConcept();
        String domain = description.getDomain();
        String descript = description.getDescription();
        String title = description.getTitle();
        String url = description.getUrl();
        String keywords = description.getKeywords();
        return descriptionRepository.create(timestamp,concept,domain,descript,title,keywords,url);
    }

    @Override
    public Description update(Description description) {
        long id = description.getId();
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
    public Description delete(String timestamp) {
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
