package com.stackroute.plasma.model;

import lombok.Data;

@Data
public class InputQuery {
    private String userId ;
    private String userQuery;
    private String jwt;
    private String role ;
    private String sessionId;
}
