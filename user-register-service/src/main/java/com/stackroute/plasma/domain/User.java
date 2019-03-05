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
    @JsonIgnore
    private String dateOfBirth;
    @JsonIgnore
    private String gender;
    @JsonIgnore
    private Long contact;


    @Id
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("setPassword")
    private String setPassword;
   }