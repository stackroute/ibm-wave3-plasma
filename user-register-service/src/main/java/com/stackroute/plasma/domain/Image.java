package com.stackroute.plasma.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Image {
    @Document(collection = "user")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Track {
        @Id
        private String imageId;
        @JsonProperty("text")
        private String imageName;
        @JsonProperty("url")
        private String imageUrl;
    }
}
