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

    Document doc;
    Url url;

    SearchOutput searchOutputt;
    List<Url> list;
    List<String> tempList = new ArrayList<>();
    String[] temp = new String[200];
    ObjectMapper objectMapper = new ObjectMapper();
public DocumentServiceImpl() {

    }












    RabbitMQSender rabbitMQSender;

//    @Autowired
//    RabbitMQSender rabbitMQSender;

   // @Autowired
//    public DocumentServiceImpl(SearchOutput searchOutput) {
//        //url=new Url();
//        this.searchOutput = searchOutput;
//        searchOutput.setUrls(new String[]{"https://www.youtube.com/watch?v=szYzBC89CPE", "https://beginnersbook.com/2013/03/oops-in-java-encapsulation-inheritance-polymorphism-abstraction/",
//                "https://www.youtube.com/watch?v=PM47JJe_8xI",
//                "https://dzone.com/articles/java-encapsulation-for-adults",
//                "https://howtodoinjava.com/oops/encapsulation-in-java-and-its-relation-with-abstraction/",
//                "https://www.guru99.com/java-oops-encapsulation.html",
//                "https://programmingstack.com/java-encapsulation.html",
//                "https://quizlet.com/177452001/java-encapsulation-flash-cards/",
//                "https://www.coursehero.com/file/14011464/Java-encapsulation-inheritance-polymorphism/",
//                "https://quizlet.com/332830793/java-encapsulationscope-quiz-flash-cards/"});
//        searchOutput.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())).toString());
//        searchOutput.setDomain("java");
//        searchOutput.setConcept("abstraction");
//    }


    @RabbitListener(queues = "${javainuse2.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(SearchOutput searchOutput) throws IOException {
            this.searchOutputt = searchOutput;
            int j = 0;
          // this.searchOutputt = this.objectMapper.readValue(searchOutput,SearchOutput);

        for (String x:searchOutput.getUrls()
             ) {
            tempList.add(x);
            temp[j++] = x;
            System.out.println("###################");
            System.out.println(tempList);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(temp);
            System.out.println("-------------"+x);
        }

//        System.out.println("Recieved Message From RabbitMQ: " + searchOutput.getConcept() +searchOutput.getUrls());
//        System.out.println("check url----------------"+ searchOutputt.getUrls()+"8888888888"+searchOutputt.getConcept());
       // this.searchOutput = searchOutput;

//        for (String x:searchOutput.getUrls()
//             ) {
//            System.out.println("-------------"+x);
//        }
//
//        System.out.println("Recieved Message From RabbitMQ: " + searchOutput.getConcept() +searchOutput.getUrls());
//        System.out.println("check url----------------"+ searchOutputt.getUrls()+"8888888888"+searchOutputt.getConcept());
//        this.searchOutput = searchOutput;

//    }
    }

    @Override
    public List<Url> getHtml() throws IOException {

        System.out.println("check inside document url----------------"+ searchOutputt.getUrls()+searchOutputt.getConcept());
        list = new ArrayList<>();
//        searchOutput.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())).toString());
//        searchOutput.setDomain("java");
//        searchOutput.setConcept("abstraction");
        //for (String urlx : searchOutputt.getUrls()) {
        for(String urlx : temp){
            url = new Url();
            //System.out.println("hello");
           // System.out.println(searchOutput.getUrls());

            Document doc = Jsoup.connect(urlx).get();

            url.setConcept(searchOutputt.getConcept());
            url.setDomain(searchOutputt.getDomain());
            url.setUrl(urlx);
            url.setDoc(doc.toString());

            System.out.println(doc.toString());

            url.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())).toString());
            rabbitMQSender.send(url);

            list.add(url);
        }

        return list;
    }
}

