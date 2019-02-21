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


    @Id
    private String userId;
    private String password;
}





