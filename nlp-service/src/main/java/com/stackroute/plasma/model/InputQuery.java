package com.stackroute.plasma.model;

public class InputQuery {
    private String emailId ;
    private String userQuery;
    private String jwt;
    private String role ;

    public InputQuery() {
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserQuery() {
        return userQuery;
    }

    public void setUserQuery(String userQuery) {
        this.userQuery = userQuery;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public InputQuery(String userId, String userQuery, String jwt, String role) {
        this.emailId = userId;
        this.userQuery = userQuery;
        this.jwt = jwt;
        this.role = role;
    }

    @Override
    public String toString() {
        return "InputQuery{" +
                "userId='" + emailId + '\'' +
                ", userQuery='" + userQuery + '\'' +
                ", jwt='" + jwt + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
