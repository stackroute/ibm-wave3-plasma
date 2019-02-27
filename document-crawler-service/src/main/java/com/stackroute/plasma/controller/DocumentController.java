package com.stackroute.plasma.controller;
<<<<<<< HEAD
=======



>>>>>>> 6e6e4cc9c1dce1c2374e7516e973c204b1e195dd
import com.stackroute.plasma.domain.SearchOutput;
import com.stackroute.plasma.domain.Url;
import com.stackroute.plasma.service.DocumentService;
import com.stackroute.plasma.service.RabbitMQSender;
import com.stackroute.plasma.service.RabbitMQSender;


import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.stackroute.plasma.service.RabbitMQSender;
<<<<<<< HEAD
import org.springframework.amqp.rabbit.annotation.RabbitListener;
=======

>>>>>>> 6e6e4cc9c1dce1c2374e7516e973c204b1e195dd
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {
    @Autowired
    private DocumentService documentService;
    private ResponseEntity<?> responseEntity;
<<<<<<< HEAD
    String docString;
    @Autowired
    SearchOutput[] searchOutput = new SearchOutput[102];
=======
    private Url url;


>>>>>>> 6e6e4cc9c1dce1c2374e7516e973c204b1e195dd
    @Autowired
    public DocumentController(DocumentService documentService)
    {
        this.documentService = documentService;
    }


    @RabbitListener(queues = "${javainuse2.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(SearchOutput[] searchOutput) throws IOException {
        System.out.println("Recieved Message From RabbitMQ: " + searchOutput);
        this.searchOutput = searchOutput;
    }

<<<<<<< HEAD
=======


>>>>>>> 6e6e4cc9c1dce1c2374e7516e973c204b1e195dd
    @GetMapping("/doc")
    public ResponseEntity<?> getContent() throws IOException {
        int k=0;
        Url url;
        for(int i=0;i<this.searchOutput.length;i++){
            for (String u:searchOutput[k].getUrls()
                 ) {
                url = new Url();
                docString = documentService.getHtml(u);
                url.setUrl(searchOutput[k].getUrls()[k]);
                url.setConcept(searchOutput[k].getConcept());
                url.setDoc(docString);
                url.setDomain(searchOutput[k].getDomain());
                url.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
                //send here the url to rabbit mq
                rabbitMQSender.send(url);
            }
        }

<<<<<<< HEAD
        return new ResponseEntity<>(null,HttpStatus.CREATED);
=======
        return new ResponseEntity(documentService.getHtml(), HttpStatus.OK);

>>>>>>> 6e6e4cc9c1dce1c2374e7516e973c204b1e195dd
    }

}


//list = new ArrayList<>();
//        searchOutput.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
//        searchOutput.setDomain("java");
//        searchOutput.setConcept("abstraction");
//        for(String urlx : searchOutput.getUrls()){
//        url = new Url();
//
//        System.out.println("hello");
//        System.out.println(searchOutput.getUrls());
//
//        Document doc = Jsoup.connect(urlx).get();
//
//        url.setConcept(searchOutput.getConcept());
//        url.setDomain(searchOutput.getDomain());
//        url.setUrl(urlx);
//        url.setDoc(doc.toString());
//        url.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
//        rabbitMQSender.send(url);
//        list.add(url);
