package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Document;
import com.stackroute.knowledgequeryservice.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class.getName());

    @Autowired
    DocumentRepository documentRepository;


    @Override
    public List<Document> getAll() {
        return documentRepository.getAll();
    }

    @Override
    public List<List<Document>> concept(List<String> concepts, List<String> levels) {
        System.out.println(concepts);
        System.out.println(levels);
        List<List<Document>> documents = new ArrayList<>();
         for (int i = 0; i < concepts.size(); i++) {
                logger.info(concepts.get(i));
                logger.info(levels.get(i));
                documents.add(documentRepository.concept(concepts.get(i), levels.get(i)));
            }
            return documents;
        }
    }

  /* @Override
    public List<Document> concept(String concept,String level) {
       List<Document> documents= documentRepository.concept(concept, level);
       return documents;
    }*/
