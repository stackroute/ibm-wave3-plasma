package com.stackroute.plasma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "userquery")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String user_query;
}
