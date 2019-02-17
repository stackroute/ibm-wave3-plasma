package com.stackroute.plasma.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    //  @GeneratedValue
    private String Id;
    // @ApiModelProperty(notes="name of track")
    private String Name;
    //   @ApiModelProperty(notes = "comments on track")
    private String dateOfBirth;
    private String gender;
    private String contact;
    private String emailId;
    private String setPassword;
    private String confirmpassword;

    }