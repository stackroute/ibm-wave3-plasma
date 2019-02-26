package com.stackroute.plasma.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public DocumentServiceImpl() {

    }

    @Override
    public String getHtml(String singleUrl) throws IOException {

            Document doc = Jsoup.connect(singleUrl).get();
            docString = doc.toString();
            return docString;

        }

    }








