package com.stackroute.clientsideloadbalancer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class User {


    @JsonProperty("name")
    private String name;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("contact")
    private String contact;

    @JsonProperty("emailId")

    private String emailId;
    @JsonProperty("password")
    private String password;
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }



   }



