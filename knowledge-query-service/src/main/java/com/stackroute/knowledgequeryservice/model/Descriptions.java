package com.stackroute.knowledgequeryservice.model;

import lombok.Data;

import java.util.List;


@Data
public class Descriptions {
    String userId;
    List<List<Description>> descriptions;
}
