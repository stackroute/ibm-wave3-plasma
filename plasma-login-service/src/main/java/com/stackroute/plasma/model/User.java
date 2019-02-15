package com.stackroute.plasma.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
    public  String getUserId() {return userId;}

    @Id
    private String userId;
    private String password;

    public void setManagerId(String managerId) {
        this.userId = managerId;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}





