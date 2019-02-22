package com.stackroute.plasma.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackroute.plasma.domain.Evaluator;
import com.stackroute.plasma.domain.Url;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class RabbitMQListner {


    Evaluator eval = new Evaluator();

    @JsonIgnore
    Document docx;
    String data;

    Evaluator eva;
    Url url;
    JSONObject jsonObj;
    private long[] html = new long[5];
    private long[] head = new long[5];
    private long[] title = new long[5];
    private long[] meta = new long[5];
    private long[] body = new long[5];
    private long[] h1 = new long[5];
    private long[] h2 = new long[5];
    private long[] h3 = new long[5];
    private long[] h4 = new long[5];
    private long[] h5 = new long[5];
    private long[] h6= new long[5];
    private long[] code = new long[5];
    private long[] address= new long[5];
    private long[] summary = new long[5];
    private long[] blockquote = new long[5];
    private long[] mark = new long[5];
    private long[] ins= new long[5];
    private long[] map = new long[5];
    private long[] p = new long[5];
    private long[] span = new long[5];
    private long[] div= new long[5];
    private long[] ul = new long[5];
    private long[] ol = new long[5];
    private long[] li = new long[5];
    private long[] article = new long[5];
    private long[] nav = new long[5];

    private  String keywords,description;
    private int[] tagVal = {10, 9, 6, 4};
    private String[] content = {"title", "h1", "p", "body"};

    private Map<String,Long> tagweight=new HashMap<>();
    private String[] level1 = {"basics", "tutorials", "example", "complete reference", "trouble shooting"};
    private String[] level2 = {"main", "fundamental", "essential", "beginner", "basics", "model", "secondary", "additional", "auxiliary", "snippets"};
    private String[] level3 = {"academic", "informational", "instructive", "guidance", "instructional", "tutorials", "training", "primary", "primitive", "foundation"};
    private String[] level4 = {"source code", "reference", "relating", "snippet", "sample", "expression", "model", "instance", "class", "function"};
    private String[] levels = {"Knowledge", "Comprehensive", "Application", "Analysis", "Synthesis", "Evaluation"};
    private List<String> strL1 = Arrays.asList(level1);
    private List<String> strL2 = Arrays.asList(level2);
    private List<String> strL3 = Arrays.asList(level3);
    private List<String> strL4 = Arrays.asList(level4);

    public RabbitMQListner() {
        eva = new Evaluator();

    }

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(Url urlx) throws IOException, ParseException {
        System.out.println("Recieved Message From RabbitMQ: " + urlx.getUrl());
        this.url=urlx;
        System.out.println("\n\n\nchandu......:\n\n\n\n"+getScore());

    }

    public void htmlTag() {
        String htmlTag = docx.select("html").text();
        String[] str = htmlTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        html[0] = countOccurences(strn, strL1)-head[0]-body[0];
        html[1] = countOccurences(strn, strL2)-head[1]-body[1];
        html[2] = countOccurences(strn, strL3)-head[2]-body[2];
        html[3] = countOccurences(strn, strL4)-head[3]-body[3];


        for(int i=0;i<4;i++){
            System.out.println("html "+html[i]);
        }
    }


    public void headTag() {
        //long h1=9;//tagweight.get("h1");
        String headTag = docx.select("head").text();
        String[] str = headTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        head[0] = countOccurences(strn, strL1)-title[0]-meta[0];
        head[1] = countOccurences(strn, strL2)-title[1]-meta[1];
        head[2] = countOccurences(strn, strL3)-title[2]-meta[2];
        head[3] = countOccurences(strn, strL4)-title[3]-meta[3];
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("head "+head[i]);
        }
    }

    public void titleTag() {

        List<String> str = Arrays.asList(docx.title().split(" "));
        title[0] = countOccurences(str, strL1);
        title[1] = countOccurences(str, strL2);
        title[2] = countOccurences(str, strL3);
        title[3] = countOccurences(str, strL4);

        for(int i=0;i<4;i++){
            System.out.println("title"+title[i]);
        }

    }


    public void metaTag() {
        int count = 0;
        description = docx.select("meta[name=description]").get(0).attr("content");
        //Print description.
        System.out.println("Meta Description: " + description);

        //Get keywords from document object.
        keywords = docx.select("meta[name=keywords]").first().attr("content");
        //Print keywords.
        System.out.println("Meta Keyword : " + keywords);

        String string= description+keywords;
        String ss1 = string.trim().replaceAll(",", "");
        List<String> str = Arrays.asList(ss1.split(" "));
        meta[0] = countOccurences(str, strL1);
        meta[1] = countOccurences(str, strL2);
        meta[2] = countOccurences(str, strL3);
        meta[3] = countOccurences(str, strL4);

        for(int i=0;i<4;i++){
            System.out.println("meta "+meta[i]);
        }

    }


    public void bodyTag() {

        String bodyTag = docx.select("body").text();
        String ss =bodyTag.toLowerCase().trim().replaceAll(":", "");
        String ss1 = ss.trim().replaceAll(",", "");
        String[] str1 = ss1.split(" ");
        List<String> str = Arrays.asList(str1);
        long[] sum=new long[4];
        for(int i=0;i<4;i++){
            sum[i]=h1[i]+h2[i]+h3[i]+h4[i]+h5[i]+h6[i]+code[i]+address[i]+summary[i]+blockquote[i]+mark[i]+ins[i]+map[i]+p[i]+span[i]+div[i]+ul[i]+ol[i]+ul[i]+article[i]+nav[i];
        }

        body[0] = countOccurences(str, strL1) - sum[0];
        body[1] = countOccurences(str, strL2) - sum[1];
        body[2] = countOccurences(str, strL3) - sum[2];
        body[3] = countOccurences(str, strL4) - sum[3];


        for(int i=0;i<4;i++){
            System.out.println("body"+body[i]);
        }
    }



    public void h1Tag() {
        //long h1=9;//tagweight.get("h1");
        String h1Tag = docx.select("h1").first().text();
        String[] str = h1Tag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        h1[0] = countOccurences(strn, strL1);
        h1[1] = countOccurences(strn, strL2);
        h1[2] = countOccurences(strn, strL3);
        h1[3] = countOccurences(strn, strL4);
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("head1 "+h1[i]);
        }
    }

    public void h2Tag() {
        //long h1=9;//tagweight.get("h1");
        String h2Tag = docx.select("h2").text();
        String[] str = h2Tag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        h2[0] = countOccurences(strn, strL1);
        h2[1] = countOccurences(strn, strL2);
        h2[2] = countOccurences(strn, strL3);
        h2[3] = countOccurences(strn, strL4);
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("head2 "+h2[i]);
        }
    }
    public void h3Tag(){
        //long h1=9;//tagweight.get("h1");
        String h3Tag = docx.select("h3").text();
        String[] str = h3Tag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        h3[0] = countOccurences(strn, strL1);
        h3[1] = countOccurences(strn, strL2);
        h3[2] = countOccurences(strn, strL3);
        h3[3] = countOccurences(strn, strL4);
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("head3  "+h3[i]);
        }
    }
    public void h4Tag() {
        String h4Tag = docx.select("h4").text();
        String[] str = h4Tag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        h4[0] = countOccurences(strn, strL1);
        h4[1] = countOccurences(strn, strL2);
        h4[2] = countOccurences(strn, strL3);
        h4[3] = countOccurences(strn, strL4);
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("head4 "+h4[i]);
        }
    }
    public void h5Tag() {
        String h5Tag = docx.select("h5").text();
        String[] str = h5Tag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        h5[0] = countOccurences(strn, strL1);
        h5[1] = countOccurences(strn, strL2);
        h5[2] = countOccurences(strn, strL3);
        h5[3] = countOccurences(strn, strL4);
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("head5 "+h5[i]);
        }
    }
    public void h6Tag() {
        String h6Tag = docx.select("h6").text();
        String[] str = h6Tag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        h6[0] = countOccurences(strn, strL1);
        h6[1] = countOccurences(strn, strL2);
        h6[2] = countOccurences(strn, strL3);
        h6[3] = countOccurences(strn, strL4);
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("head6 "+h6[i]);
        }
    }


    public void codeTag() {
        String codeTag = docx.select("code").text();
        String ss = codeTag.toLowerCase().trim().replaceAll(":", "");
        String ss1 = ss.trim().replaceAll(",", "");
        String[] str1 = ss1.split(" ");
        List<String> str = Arrays.asList(str1);

        code[0] = (countOccurences(str, strL1));
        code[1] = (countOccurences(str, strL2));
        code[2] = (countOccurences(str, strL3));
        code[3] = (countOccurences(str, strL4));


        for(int i=0;i<4;i++){
            System.out.println("code "+code[i]);
        }
    }

    public void addressTag() {
        String addressTag = docx.select("address").text();
        String ss = addressTag.toLowerCase().trim().replaceAll(":", "");
        String ss1 = ss.trim().replaceAll(",", "");
        String[] str1 = ss1.split(" ");
        List<String> str = Arrays.asList(str1);

        address[0] = (countOccurences(str, strL1));
        address[1] = (countOccurences(str, strL2));
        address[2] = (countOccurences(str, strL3));
        address[3] = (countOccurences(str, strL4));


        for(int i=0;i<4;i++){
            System.out.println("address "+address[i]);
        }
    }



    public void summaryTag() {
        String summaryTag = docx.select("summary").text();
        String ss = summaryTag.toLowerCase().trim().replaceAll(":", "");
        String ss1 = ss.trim().replaceAll(",", "");
        String[] str1 = ss1.split(" ");
        List<String> str = Arrays.asList(str1);

        summary[0] = (countOccurences(str, strL1));
        summary[1] = (countOccurences(str, strL2));
        summary[2] = (countOccurences(str, strL3));
        summary[3] = (countOccurences(str, strL4));


        for(int i=0;i<4;i++){
            System.out.println("summary "+summary[i]);
        }
    }
    public void blockQuoteTag() {
        String blockQuoteTag = docx.select("blockquote").text();
        String[] str = blockQuoteTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        blockquote[0] = countOccurences(strn, strL1);
        blockquote[1] = countOccurences(strn, strL2);
        blockquote[2] = countOccurences(strn, strL3);
        blockquote[3] = countOccurences(strn, strL4);



        for(int i=0;i<4;i++){
            System.out.println("blockquote "+h6[i]);
        }
    }


    public void markTag() {
        String markTag = docx.select("mark").text();
        String[] str = markTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        mark[0] = countOccurences(strn, strL1);
        mark[1] = countOccurences(strn, strL2);
        mark[2] = countOccurences(strn, strL3);
        mark[3] = countOccurences(strn, strL4);

        for(int i=0;i<4;i++){
            System.out.println("mark "+mark[i]);
        }
    }



    public void insTag() {
        String insTag = docx.select("ins").text();
        String[] str = insTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        ins[0] = countOccurences(strn, strL1);
        ins[1] = countOccurences(strn, strL2);
        ins[2] = countOccurences(strn, strL3);
        ins[3] = countOccurences(strn, strL4);


        for(int i=0;i<4;i++){
            System.out.println("ins "+ins[i]);
        }
    }



    public void mapTag() {
        String mapTag = docx.select("map").text();
        String[] str = mapTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        map[0] = countOccurences(strn, strL1);
        map[1] = countOccurences(strn, strL2);
        map[2] = countOccurences(strn, strL3);
        map[3] = countOccurences(strn, strL4);



        for(int i=0;i<4;i++){
            System.out.println("map "+map[i]);
        }
    }


    public void pTag() {

        String ss = docx.select("p").text().toLowerCase().trim().replaceAll(":", "");
        String ss1 = ss.trim().replaceAll(",", "");
        String[] str1 = ss1.split(" ");
        List<String> strn = Arrays.asList(str1);

        p[0] = countOccurences(strn, strL1);
        p[1] = countOccurences(strn, strL2);
        p[2] = countOccurences(strn, strL3);
        p[3] = countOccurences(strn, strL4);

        for(int i=0;i<4;i++){
            System.out.println("p tag"+p[i]);
        }
    }


    public void spanTag() {
        String spanTag = docx.select("span").text();
        String[] str = spanTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        span[0] = countOccurences(strn, strL1);
        span[1] = countOccurences(strn, strL2);
        span[2] = countOccurences(strn, strL3);
        span[3] = countOccurences(strn, strL4);
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("span "+span[i]);
        }
    }

    public void divTag() {
        String divTag = docx.select("div").text();
        String ss = divTag.toLowerCase().trim().replaceAll(":", "");
        String ss1 = ss.trim().replaceAll(",", "");
        String[] str1 = ss1.split(" ");
        List<String> str = Arrays.asList(str1);

        div[0] = (countOccurences(str, strL1));
        div[1] = (countOccurences(str, strL2));
        div[2] = (countOccurences(str, strL3));
        div[3] = (countOccurences(str, strL4));


        for(int i=0;i<4;i++){
            System.out.println("div "+div[i]);
        }
    }





    public void liTag() {
        String liTag = docx.select("li").text();
        String[] str = liTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        li[0] = countOccurences(strn, strL1);
        li[1] = countOccurences(strn, strL2);
        li[2] = countOccurences(strn, strL3);
        li[3] = countOccurences(strn, strL4);
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("li "+li[i]);
        }
    }




    public void ulTag() {
        String ulTag = docx.select("ul").text();
        String[] str = ulTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        ul[0] = countOccurences(strn, strL1)-li[0];
        ul[1] = countOccurences(strn, strL2)-li[1];
        ul[2] = countOccurences(strn, strL3)-li[2];
        ul[3] = countOccurences(strn, strL4)-li[3];
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("ul "+ul[i]);
        }
    }


    public void olTag() {
        String olTag = docx.select("ol").text();
        String[] str = olTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        ol[0] = countOccurences(strn, strL1)-li[0];
        ol[1] = countOccurences(strn, strL2)-li[1];
        ol[2] = countOccurences(strn, strL3)-li[2];
        ol[3] = countOccurences(strn, strL4)-li[3];
        //return h1Tag;


        for(int i=0;i<4;i++){
            System.out.println("ol "+ol[i]);
        }
    }


    public void articleTag() {
        String articleTag = docx.select("article").text();
        String[] str = articleTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        article[0] = countOccurences(strn, strL1);
        article[1] = countOccurences(strn, strL2);
        article[2] = countOccurences(strn, strL3);
        article[3] = countOccurences(strn, strL4);

        for(int i=0;i<4;i++){
            System.out.println("article "+article[i]);
        }
    }

    public void navTag() {

        String navTag = docx.select("nav").text();
        String[] str = navTag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        nav[0] = countOccurences(strn, strL1);
        nav[1] = countOccurences(strn, strL2);
        nav[2] = countOccurences(strn, strL3);
        nav[3] = countOccurences(strn, strL4);


        for(int i=0;i<4;i++){
            System.out.println("nav "+nav[i]);
        }
    }


    public int countOccurences(List<String> str, List<String> strL) {
        int countx = 0;
        for (String s : str) {
            if (strL.contains(s.trim())) {
                countx++;
            }
        }
        return countx;
    }


    public Evaluator getScore() throws IOException, ParseException {
        this.docx = Jsoup.parse(url.getDoc());
        System.out.println("in method");
        long[][] val = new long[26][4];
        Long[] score = new Long[4];
        int i=0;

        getWeights();
        System.out.println("starting methods");
        h1Tag();
        h2Tag();
        h3Tag();
        h4Tag();
        h5Tag();
        h6Tag();
        codeTag();
        addressTag();
        summaryTag();
        blockQuoteTag();
        markTag();
        insTag();
        mapTag();
        pTag();
        spanTag();
        divTag();
        ulTag();
        olTag();
        liTag();
        articleTag();
        navTag();

        bodyTag();

        titleTag();
        metaTag();

        headTag();

        htmlTag();

        System.out.println("ending methods");
        for (int j = 0; j < 4; j++) {
            val[0][j] = html[j]*tagweight.get("html");
            System.out.println("html "+j+" "+ val[0][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[1][j] = head[j]*tagweight.get("head");
            System.out.println("head "+j+" "+val[1][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[2][j] = title[j]*tagweight.get("title");
            System.out.println("title "+j+" "+val[2][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[3][j] = meta[j]*tagweight.get("meta");
            System.out.println("meta "+j+" "+val[3][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[4][j] = body[j]*tagweight.get("body");
            System.out.println("body "+j+" "+val[4][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[5][j] = h1[j]*tagweight.get("h1");
            System.out.println("h1 "+j+" "+val[5][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[6][j] = h2[j]*tagweight.get("h2");
            System.out.println("h2 "+j+" "+val[6][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[7][j] = h3[j]*tagweight.get("h3");
            System.out.println("h3"+j+" "+val[7][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[8][j] = h4[j]*tagweight.get("h4");
            System.out.println("h4 "+j+" "+val[8][j]);
        }

        for (int j = 0; j < 4; j++) {
            val[9][j] = h5[j]*tagweight.get("h5");
            System.out.println("h5 "+j+" "+val[9][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[10][j] = h6[j]*tagweight.get("h6");
            System.out.println("h6 "+j+" "+val[10][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[11][j] = code[j]*tagweight.get("code");
            System.out.println("code "+j+" "+val[11][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[12][j] = address[j]*tagweight.get("address");
            System.out.println("address "+j+" "+val[12][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[13][j] = summary[j]*tagweight.get("summary");
            System.out.println("summary "+j+" "+val[13][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[14][j] = blockquote[j]*tagweight.get("blockquote");
            System.out.println("blockquote "+j+" "+val[14][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[15][j] = mark[j]*tagweight.get("mark");
            System.out.println("mark "+j+" "+val[15][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[16][j] = ins[j]*tagweight.get("ins");
            System.out.println("ins "+j+" "+val[16][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[17][j] = map[j]*tagweight.get("map");
            System.out.println("map "+j+" "+val[17][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[18][j] = p[j]*tagweight.get("p");
            System.out.println("p "+j+" "+val[18][j]);
        }
        for (int j = 0; j < 4; j++) {
            val[19][j] = span[j]*tagweight.get("span");
            System.out.println("span "+j+" "+val[8][j]);
        } for (int j = 0; j < 4; j++) {
            val[20][j] = div[j]*tagweight.get("div");
            System.out.println("div "+j+" "+val[20][j]);
        } for (int j = 0; j < 4; j++) {
            val[21][j] = ul[j]*tagweight.get("ul");
            System.out.println("ul "+j+" "+val[21][j]);
        } for (int j = 0; j < 4; j++) {
            val[22][j] = ol[j]*tagweight.get("ol");
            System.out.println("ol "+j+" "+val[22][j]);
        } for (int j = 0; j < 4; j++) {
            val[23][j] = li[j]*tagweight.get("li");
            System.out.println("li"+j+" "+val[23][j]);
        } for (int j = 0; j < 4; j++) {
            val[24][j] = article[j]*tagweight.get("article");
            System.out.print("article "+j+" "+val[24][j]);
        }for (int j = 0; j < 4; j++) {
            val[25][j] = nav[j]*tagweight.get("nav");
            System.out.print("nav j:"+val[25][j]);
        }
        //Scores calculation
        for (int j = 0; j < 4; j++) {
            score[j] = Long.valueOf(0);
            for (i = 0; i < 26; i++) {

                score[j] = score[j] + (val[i][j]);


            }
            System.out.println(score[j]);
        }

        List<Long> scores = Arrays.asList(score);
        int level = scores.indexOf(Collections.max(scores));

        System.out.println("starting object assign");
        this.eva.setUrl(url.getUrl());
        this.eva.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
        this.eva.setDomain(url.getDomain());
        this.eva.setConcept(url.getConcept());

        this.eva.setConfidenceScore(Collections.max(scores));

        this.eva.setLevel(levels[level]);
        this.eva.setDescription(description);
        this.eva.setKeywords(keywords);
        this.eva.setTitle(this.docx.title());


        System.out.println("ending object assign");

        System.out.print(this.eva);
        return  this.eva;
    }


    public void getWeights() throws IOException, ParseException {
        FileReader fileReader = new FileReader("tagweights.json");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fileReader);

        //Object obj = new JSONParser(fileReader);//.parse(new FileReader("/home/chandra/Desktop/Project new/redis/src/main/java/com/stackroute/plasma/redis/seeddata/tagweights.json/tagweight.txt"));
        JSONObject jsonObj = new JSONObject((HashMap) obj);
        //itemRepository.save(jsonObj);

        tagweight.putAll((Map<? extends String, ? extends Long>) obj);

        //return jsonObj;
    }

    /*public void getW() throws IOException, ParseException {
        JSONObject jsonO=getWeights();

        System.out.print(jsonO.get("title").equals("title"));
    }
*/
/*
    public void getWeight() throws FileNotFoundException, ParseException {

//
//        JSONParser parse = new JSONParser();
//        JSONObject jobj = (JSONObject)parse.parse(inline);



        FileReader fileReader = new FileReader("/home/chandra/Desktop/Product/ibm-wave3-plasma/evaluator-service/src/main/resources/tagweight.txt");
        JSONParser parser = new JSONParser(fileReader);
        Object obj = parser.parse();

        JSONObject jsonObj = new JSONObject((Map)obj);
    }


*/



}
