package com.stackroute.knowledgequeryservice.model;

import lombok.Data;
import java.util.List;

@Data
public class Documents {
    private String userId;
    private String role;
    private String jwt;
    private String sessionId;
    List<List<Document>> documents;
    //List<Document> documents;
}
