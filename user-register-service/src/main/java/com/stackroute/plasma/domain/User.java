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

    //@Id
    //private String id;
    @JsonProperty("name")
    private String name;
    private String dateOfBirth;
    private String gender;
    private Long contact;
//    private Integer contact;

    @Id
    @JsonProperty("emailId")
    private String emailId;
    private String setPassword;
    //private String confirmpassword;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public void setContact(String contact) {
//        this.contact = contact;
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//
//    public String getSetPassword() {
//        return setPassword;
//    }
//
//    public void setSetPassword(String setPassword) {
//        this.setPassword = setPassword;
//    }
//
//    public String getConfirmpassword() {
//        return confirmpassword;
//    }
//
//    public void setConfirmpassword(String confirmpassword) {
//        this.confirmpassword = confirmpassword;
//    }
    /*public String getId() {
        return id;
    }*/

    //public void setId(String id) {
      //  this.id = id;
    //}

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSetPassword() {
        return setPassword;
    }

    public void setSetPassword(String setPassword) {
        this.setPassword = setPassword;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }*/
}