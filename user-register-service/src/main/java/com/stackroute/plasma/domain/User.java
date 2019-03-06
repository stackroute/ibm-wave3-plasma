package com.stackroute.plasma.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @JsonIgnore
    private String name;
<<<<<<< HEAD
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("contact")
=======
    @JsonIgnore
    private String dateOfBirth;
    @JsonIgnore
    private String gender;
    @JsonIgnore
>>>>>>> f82a88f43470e0b6480196ffed9b1a9118671d66
    private Long contact;


    @Id
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("setPassword")
    private String setPassword;
   }