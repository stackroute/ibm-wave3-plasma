package com.stackroute.searchservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "searchdata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchStorage {
    private String domain;
    @Id
    private String concept;
    private String[] urls;
}
