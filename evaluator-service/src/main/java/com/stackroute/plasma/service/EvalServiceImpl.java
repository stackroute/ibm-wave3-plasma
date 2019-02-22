/*
package com.stackroute.plasma.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackroute.plasma.domain.Evaluator;
import com.stackroute.plasma.domain.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class EvalServiceImpl  implements  EvalService{

    @JsonIgnore
    Document docx;
    String data;
    Url url;
  //  Document doc;
    Evaluator eva;
    private int[] t=new int[5];
    private int[] h=new int[5];
    private int[] p=new int[5];
    private int[] b=new int[5];
    private int[] tagVal={10,9,6,4};
    private String[] content={"title","h1","p","body"};
    private String[] level1 = {"basics","tutorials","example","complete reference","trouble shooting"};
    private String[] level2 = {"main","fundamental","essential","beginner","basics","model","secondary","additional","auxiliary","snippets"};
    private String[] level3 = {"academic","informational","instructive","guidance","instructional","tutorials","training","primary","primitive","foundation"};
    private String[] level4 = {"source code","reference","relating","snippet","sample","expression","model","instance","class","function"};
    private String[] levels={"Knowledge","Comprehensive","Application","Analysis","Synthesis","Evaluation"};
    private List<String> strL1 = Arrays.asList(level1);
    private List<String> strL2 = Arrays.asList(level2);
    private List<String> strL3 = Arrays.asList(level3);
    private List<String> strL4 = Arrays.asList(level4);
    //RabbitMQListner rmq= new RabbitMQListner();
    EvalServiceImpl evalServiceImpl;
    private Url urlx;

    public Document getDocx() {
        return docx;
    }

    public void setDocx(String docx) {
        this.docx = Jsoup.parse(docx);
    }

    */
/*  private String url = "https://www.guru99.com/java-oops-class-objects.html";
*//*

        public EvalServiceImpl(String doc) throws IOException{
            this.docx=Jsoup.parse(doc);
        }


  */
/*  @Override
    public String getScore() throws IOException {
            System.out.println("in method................................\n\n\n");
            int[][] val=new int[4][4];
            Integer[] score=new Integer[4];
            int i=0;

            //String str=url.getDoc();
            //evalServiceImpl.setDocx(str);
        System.out.println("\n\n\n\nin method after setdoc................................"+url.getUrl());
*//*
*/
/*

            titleTag();
            headTag();
            pTag();
            bodyTag();

            for(int j=0;j<4;j++){
                val[0][j]=t[j];
            }
            for(int j=0;j<4;j++){
                val[1][j]=h[j];
            }
            for(int j=0;j<4;j++){
                val[2][j]=p[j];
            }
            for(int j=0;j<4;j++){
                val[3][j]=b[j];
            }

            for(int j=0;j<4;j++){
                score[j]=0;
                for(i=0;i<4;i++){

                    score[j]=score[j]+(val[i][j]*tagVal[i]);

                }
            }

*//*
*/
/*


           *//*
*/
/* List<Integer> scores = Arrays.asList(score);
            int level=scores.indexOf(Collections.max(scores));


        eva = new Evaluator();*//*
*/
/*
        *//*
*/
/*eva.setUrl(url.getUrl());
        eva.setDomain(url.getDomain());
        eva.setConcept(url.getConcept());
        eva.setUrl(url.getUrl());*//*
*/
/*
      // System.out.println("chandu hdsjjsds"+url.getUrl());
       // eva.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
      *//*
*/
/*  eva.setDomain("java");
        eva.setConcept("class");
        eva.setUrl("https://www.guru99.com/java-oops-class-objects.html");*//*
*/
/*
      *//*
*/
/*  eva.setConfidenceScore(Collections.max(scores));

        eva.setLevel(levels[level]);*//*
*/
/*
        return "hello";

    }*//*


*/
/*
    public void getMessage(Url urlx){

        this.url=urlx;
        System.out.println("getting message..."+this.url + this.url.getUrl());

    }
*//*




   */
/* @Override
    public Evaluator getObj(){
        return this.eva;
    }*//*


    @RabbitListener(queues="${javainuse.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(Url url) throws IOException {
        //System.out.println("Recieved Message From RabbitMQ: " +url.getUrl() );
        //System.out.println("Recieved Message From RabbitMQ: " +url.getDoc());
        System.out.println("Recieved Message From RabbitMQ: " +url.getUrl());

        this.urlx=url;
        this.urlx.setUrl(url.getUrl());
        this.urlx.setDoc(url.getDoc());
        this.urlx.setDomain(url.getDomain());
        this.urlx.setConcept(url.getConcept());
        //  evaluator.setUrl(url.getUrl());
        new EvalServiceImpl(url.getDoc());
        System.out.println(evalServiceImpl.getScore());
    }
}
*/
