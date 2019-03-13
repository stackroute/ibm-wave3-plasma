package com.stackroute.notificationservice.domain;

import lombok.Data;

import java.util.List;

@Data
public class Documents {
    String emailId;
    private String role;
    private String jwt;
    List<List<Document>> documents;
}
