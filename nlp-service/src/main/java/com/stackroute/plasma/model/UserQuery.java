package com.stackroute.plasma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "userquery")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery {
    @Id
    private String userId;
    private String userQuery;
    private String jwt;
    private String role;
    private String sessionId;
}
