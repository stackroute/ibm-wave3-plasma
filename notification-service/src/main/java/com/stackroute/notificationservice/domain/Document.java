package com.stackroute.notificationservice.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Document {

    private long id;

    @ApiModelProperty(notes = "Timestamp as per the search-service")
    private String timestamp;

    @ApiModelProperty(notes = "Concept to search for")
    private String concept;

    @ApiModelProperty(notes = "Concept to search for under particular domain")
    private String domain;

    @ApiModelProperty(notes = "Basic description for the URL")
    private String description;

    @ApiModelProperty(notes = "Title of the URL")
    private String title;

    @ApiModelProperty(notes = "URL contains the details of the concept, present under domain")
    private String url;

    @ApiModelProperty(notes = "basic keywords present in the URL")
    private String keywords;

    private String level;

    private float confidenceScore;

}
