package com.stackroute.plasma.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SearchQuery {

    private String id;
    // private Timestamp dateTime;
    private String domain;
    private String[] concepts; //= {"encapsulation","abstraction"};

}
