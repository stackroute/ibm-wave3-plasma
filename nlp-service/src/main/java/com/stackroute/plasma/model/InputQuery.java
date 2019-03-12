package com.stackroute.plasma.model;

public class InputQuery {
    private String userid ;
    private String user_query;
    private String jwt;
    private String role ;

    public InputQuery(String userid, String user_query, String jwt, String role) {
        this.userid = userid;
        this.user_query = user_query;
        this.jwt = jwt;
        this.role = role;
    }

    public InputQuery() {
    }

    public String getUser_id() {
        return userid;
    }

    public void setUser_id(String user_id) {
        this.userid = user_id;
    }

    public String getUser_query() {
        return user_query;
    }

    public void setUser_query(String user_query) {
        this.user_query = user_query;
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

    @Override
    public String toString() {
        return "InputQuery{" +
                "user_id='" + userid + '\'' +
                ", user_query='" + user_query + '\'' +
                ", jwt='" + jwt + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
