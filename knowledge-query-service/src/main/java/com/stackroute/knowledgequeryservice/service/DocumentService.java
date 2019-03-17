package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Document;
import java.util.List;

public interface DocumentService {
    public List<Document> getAll();
    //public List<Document> concept(String concept,String level);
    public List<List<Document>> concept(List<String> concepts, List<String> levels);
}
