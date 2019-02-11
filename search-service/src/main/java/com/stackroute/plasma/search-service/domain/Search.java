package com.stackroute.plasma.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@Builder
public class Search {
    @ApiModelProperty(notes = "Domain name" , required = true)
    private String domainName;
    @ApiModelProperty(notes = "Do concept about to search")
    private String[] concepts;

    public Search(String domainName, String[] concepts) {
        this.domainName = domainName;
        this.concepts = concepts;
    }
}
