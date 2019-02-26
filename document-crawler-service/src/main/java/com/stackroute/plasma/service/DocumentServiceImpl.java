package com.stackroute.plasma.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.plasma.domain.SearchOutput;
import com.stackroute.plasma.domain.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @JsonIgnore
    String docString;

//    @RabbitListener(queues = "${javainuse2.rabbitmq.queue}")
//    public void recievedMessage(SearchOutput searchOutput) throws IOException {
//
//
//        System.out.println("Recieved Message From RabbitMQ: " + searchOutput.toString());
//       // this.searchOutput = searchOutput;
//    }


    @Override
    public String getHtml(String singleUrl) throws IOException {

        Document document = Jsoup.connect(singleUrl).get();
        docString = document.toString();
        return docString;

    }
}