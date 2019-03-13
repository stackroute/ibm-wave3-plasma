package com.stackroute.notificationservice.domain;

import lombok.Data;
import java.util.List;


@Data
public class Descriptions {
    String emailId;
    private String role;
    private String jwt;
    List<List<Description>> descriptions;
}
