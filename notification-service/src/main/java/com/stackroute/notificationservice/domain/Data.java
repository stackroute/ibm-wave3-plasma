package com.stackroute.notificationservice.domain;
import lombok.*;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class Data {
    private String sessionId;
    private String description;
    private String title;
    private String url;
    private String keywords;

}


