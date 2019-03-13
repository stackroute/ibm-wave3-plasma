package com.stackroute.plasma.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @Id
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



