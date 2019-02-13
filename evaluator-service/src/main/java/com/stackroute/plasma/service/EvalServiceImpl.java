package com.stackroute.plasma.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackroute.plasma.domain.Evaluator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

    Document docx;
    String data;
    @JsonIgnore
    Document doc;
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


    private String url = "https://www.guru99.com/java-oops-class-objects.html";

    public EvalServiceImpl() throws IOException{
        this.docx = Jsoup.connect(url).get();
    }
    public String titleTag() throws IOException {
        int count=0;
        List<String> str= Arrays.asList(docx.title().split(" "));
        t[0]=countOccurences(str,strL1);
        t[1]=countOccurences(str,strL2);
        t[2]=countOccurences(str,strL3);
        t[3]=countOccurences(str,strL4);
        return docx.title();
    }


    public String pTag() throws IOException {
        //Document docx = Jsoup.connect(url).get();
        String ss=docx.select("p").text().toLowerCase().trim().replaceAll(":","");
        String ss1=ss.trim().replaceAll(",","");
        String[] str1=ss1.split(" ");


        String pTag = docx.select("p").text();
        List<String> strn = Arrays.asList(str1);

        p[0]=countOccurences(strn,strL1);
        p[1]=countOccurences(strn,strL2);
        p[2]=countOccurences(strn,strL3);
        p[3]=countOccurences(strn,strL4);
        return pTag;
    }

    public String headTag() throws IOException {
        String h1Tag = docx.select("h1").first().text();
        String[] str=h1Tag.toLowerCase().trim().split(" ");
        List<String> strn = Arrays.asList(str);
        h[0]=countOccurences(strn,strL1);
        h[1]=countOccurences(strn,strL2);
        h[2]=countOccurences(strn,strL3);
        h[3]=countOccurences(strn,strL4);
        return h1Tag;
    }

    public String bodyTag() throws IOException {
        data = docx.text();

        String ss=docx.text().toLowerCase().trim().replaceAll(":","");
        String ss1=ss.trim().replaceAll(",","");
        String[] str1=ss1.split(" ");
        List<String> str = Arrays.asList(str1);

        b[0]=countOccurences(str,strL1)-t[0]-p[0]-h[0];
        b[1]=countOccurences(str,strL2)-t[1]-p[1]-h[1];
        b[2]=countOccurences(str,strL3)-t[2]-p[2]-h[2];
        b[3]=countOccurences(str,strL4)-t[3]-p[3]-h[3];
        return data;
    }
    public int countOccurences(List<String> str,List<String> strL){
        int countx=0;
        for (String s : str) {
            if (strL.contains(s.trim())){
                countx++;
            }
        }
        return countx;
    }


    @Override
    public Evaluator getScore() throws IOException {
            System.out.println("in method");
            int[][] val=new int[4][4];
            Integer[] score=new Integer[4];
            int i=0;

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

            List<Integer> scores = Arrays.asList(score);
            int level=scores.indexOf(Collections.max(scores));


        eva = new Evaluator();
        eva.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
        eva.setDomain("java");
        eva.setConcept("class");
        eva.setUrl("https://www.guru99.com/java-oops-class-objects.html");
        eva.setConfidenceScore(Collections.max(scores));

        eva.setLevel(levels[level]);
        return eva;

    }


}
