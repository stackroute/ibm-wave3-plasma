package com.stackroute.knowledgequeryservice.model;

import lombok.Data;

import java.util.List;


@Data
public class Documents {
    String userId;
    List<List<Document>> documents;
}
