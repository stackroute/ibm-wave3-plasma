package com.stackroute.plasma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;



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
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @JsonProperty("emailId")
    @Id
    private String emailId;
    @JsonProperty("password")
    private String password;
}
