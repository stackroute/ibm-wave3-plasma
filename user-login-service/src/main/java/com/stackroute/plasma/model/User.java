package com.stackroute.plasma.model;


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

public class User {


    @Id
    private String userId;
    private String password;
    private String role;
}





