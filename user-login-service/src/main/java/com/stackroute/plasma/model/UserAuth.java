package com.stackroute.plasma.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserAuth {


    @JsonProperty("userId")
    @Id
    private String userId;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("contact")
    private String contact;
    private String role;

    public UserAuth(String userId, String password, String role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

}





