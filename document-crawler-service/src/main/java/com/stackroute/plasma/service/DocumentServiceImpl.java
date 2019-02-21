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
    Document doc;
    Url url;

    SearchOutput searchOutput;
    List<Url> list;

    public DocumentServiceImpl() {

    }
    @Autowired
    public DocumentServiceImpl(SearchOutput searchOutput) {
        //url=new Url();
        this.searchOutput=searchOutput;
        searchOutput.setUrls(new String[]{"https://www.youtube.com/watch?v=szYzBC89CPE","https://beginnersbook.com/2013/03/oops-in-java-encapsulation-inheritance-polymorphism-abstraction/",
                "https://www.youtube.com/watch?v=PM47JJe_8xI",
                "https://dzone.com/articles/java-encapsulation-for-adults",
                "https://howtodoinjava.com/oops/encapsulation-in-java-and-its-relation-with-abstraction/",
                "https://www.guru99.com/java-oops-encapsulation.html",
                "https://programmingstack.com/java-encapsulation.html",
                "https://quizlet.com/177452001/java-encapsulation-flash-cards/",
                "https://www.coursehero.com/file/14011464/Java-encapsulation-inheritance-polymorphism/",
                "https://quizlet.com/332830793/java-encapsulationscope-quiz-flash-cards/"});
    }



    @RabbitListener(queues = "${javainuse.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(SearchOutput searchOutput) throws IOException {
        System.out.println("Recieved Message From RabbitMQ: " + searchOutput.getUrls());
        this.searchOutput = searchOutput;
    }



    @Override
    public List<Url> getHtml() throws IOException {


        list = new ArrayList<>();
        searchOutput.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
        searchOutput.setDomain("java");
        searchOutput.setConcept("abstraction");
        for(String urlx : searchOutput.getUrls()){
            url = new Url();

            System.out.println("hello");
            System.out.println(searchOutput.getUrls());

            Document doc = Jsoup.connect(urlx).get();

            url.setConcept(searchOutput.getConcept());
            url.setDomain(searchOutput.getDomain());
            url.setUrl(urlx);
            url.setDoc(doc.toString());
            url.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
            //list.add(doc.toString());
            list.add(url);

            //return url;
        }

//        System.out.println("the complete searchOutput string array is  "+url.toString());



//        System.out.println("the complete searchOutput string array is  "+url.toString());


        //String uri[]={"https://www.tutorialspoint.com/java/", "https://www.tutorialspoint.com/java/java_variable_types.htm", "https://www.geeksforgeeks.org/encapsulation-in-java/", "https://www.geeksforgeeks.org/access-modifiers-java/"};

//        for(String urlx : uri)
        return list;



    }




}
