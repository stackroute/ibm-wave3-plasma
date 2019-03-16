package com.stackroute.plasma.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.plasma.domain.SearchOutput;
import com.stackroute.plasma.domain.Url;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class.getName());

    @JsonIgnore

    String docString;

    Document doc;
    Url url;

    SearchOutput searchOutputt;
    List<Url> list;
    List<String> tempList = new ArrayList<>();
    String[] temp = new String[200];
    ObjectMapper objectMapper = new ObjectMapper();

    public DocumentServiceImpl() {

    }

   @Autowired
   RabbitMQSender rabbitMQSender;

    @RabbitListener(queues = "${javainuse2.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(SearchOutput searchOutput) throws IOException {

        this.searchOutputt = searchOutput;
         for (String x:searchOutput.getUrls()) {
            logger.info("-------------"+x);
            }
         logger.info("Recieved Message From RabbitMQ: " + searchOutput.getConcept() +searchOutput.getUrls());
         logger.info("check url----------------"+ searchOutputt.getUrls()+"8888888888"+searchOutputt.getConcept());
         //DIRECT!
         getHtml();

   }
     int j = 0;

    @Override
    public List<Url> getHtml() throws IOException {


        logger.info("check inside document url----------------"+ searchOutputt.getUrls()+searchOutputt.getConcept());
        list = new ArrayList<>();

        for (String urlx : searchOutputt.getUrls()) {

            if(urlx == null){
                System.out.println("NULL URL FOUND");
                continue;
            }
            else {
                url = new Url();
                Document doc = Jsoup.connect(urlx).get();
                url.setConcept(searchOutputt.getConcept());
                url.setDomain(searchOutputt.getDomain());
                url.setUrl(urlx);
                url.setDoc(doc.toString());
                logger.info(doc.toString());
                url.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
                url.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
                rabbitMQSender.send(url);

                list.add(url);
            }
        }
        rabbitMQSender.inform();

        return list;
    }
}