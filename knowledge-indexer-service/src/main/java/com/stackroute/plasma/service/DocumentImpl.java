package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Document;
import com.stackroute.plasma.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentImpl implements DocumentService{

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Document create(Document description) {

        long id = description.getId();
        //Timestamp timestamp = description.getTimestamp();
        String timestamp = description.getTimestamp();
        String concept = description.getConcept();
        String domain = description.getDomain();
        String descript = description.getDescription();
        String title = description.getTitle();
        String url = description.getUrl();
        String keywords = description.getKeywords();
        String level = description.getLevel();
        float confidenceScore = description.getConfidenceScore();
        return documentRepository.create(timestamp,concept,domain,descript,title,keywords,url,level,confidenceScore);
    }

    @Override
    public Document update(Document description) {
        long id = description.getId();
        //Timestamp timestamp = description.getTimestamp();
        String timestamp = description.getTimestamp();
        String concept = description.getConcept();
        String domain = description.getDomain();
        String descript = description.getDescription();
        String title = description.getTitle();
        String url = description.getUrl();
        String keywords = description.getKeywords();
        return documentRepository.update(id,timestamp,concept,domain,descript,title,keywords,url);
    }

    @Override
    public Document delete(String timestamp) {
        return documentRepository.delete(timestamp);
    }

    @Override
    public Document delete(long id) {
        return documentRepository.delete(id);
    }

    @Override
    public Document delete(String concept, String domain) {
        return documentRepository.delete(concept,domain);
    }
}
