package com.stackroute.plasma.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Url.class)
public class Url {
    @JsonProperty("url")
    private String url;
    @JsonProperty("concept")
    private String concept;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("doc")
    private String doc;


    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                ", concept='" + concept + '\'' +
                ", domain='" + domain + '\'' +
                ", doc=" + doc +
                '}';
    }
}