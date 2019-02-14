package com.stackroute.plasma.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackroute.plasma.domain.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class DocumentServiceImpl implements DocumentService {
    @JsonIgnore
    Document doc;
    Url url;

    @Override
    public Url getDocument() throws IOException {
        url = new Url();
        url.setConcept("class");
        url.setDomain("java");
        url.setUrl("http://www.dustyfeet.com/");
        doc = Jsoup.connect("http://www.dustyfeet.com/")
                .header("Accept", "application/json")
                .timeout(600000)
                .get();
        url.setDoc(doc.toString());
        url.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
        return url;
    }

}
//    @Override
//    public Document getHtmlContent() throws IOException {
//        doc = Jsoup.connect("http://www.microscopy-uk.org.uk/mag/indexmag.html?http://www.microscopy-uk.org.uk/mag/wimsmall/smal1.html")
//                .header("Accept", "application/json")
//                .timeout(600000)
//                .get();
//        System.out.println("RESPONSE data"+doc);
//
//        return doc;
//    }