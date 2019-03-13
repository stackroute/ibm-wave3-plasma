package com.stackroute.plasma.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackroute.plasma.domain.Evaluator;
import com.stackroute.plasma.domain.Url;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EvaluatorServiceImpl implements EvaluatorService  {
    Logger logger = LoggerFactory.getLogger(EvaluatorServiceImpl.class.getName());

    Evaluator eval = new Evaluator();

    @Autowired
    RabbitMQSender rabbitMQSender;

    @JsonIgnore
    Document docx;
    Evaluator eva;
    Url url;

    int evalcount=0;

    private String keywords;
    private String description;
    private Map<String, Long> tagweight = new HashMap<>();
    private String[] levels = {"basics", "tutorials", "example", "completeReference", "troubleShooting", "gettingStarted"};

    private long[] indicatorVal = new long[6];
    private long[] counterIndicatorVal = new long[6];

    private JSONArray basicsIndicatorTerms;
    private JSONArray tutorialsIndicatorTerms;
    private JSONArray exampleIndicatorTerms;
    private JSONArray completeReferenceIndicatorTerms;
    private JSONArray troubleShootingIndicatorTerms;
    private JSONArray gettingStartedIndicatorTerms;
    private JSONArray basicsCounterIndicatorTerms;
    private JSONArray tutorialsCounterIndicatorTerms;
    private JSONArray exampleCounterIndicatorTerms;
    private JSONArray completeReferenceCounterIndicatorTerms;
    private JSONArray troubleShootingCounterIndicatorTerms;
    private JSONArray gettingStartedCounterIndicatorTerms;

    private List<String> htmlDoc;
    private List<String> headDoc;
    private List<String> titleDoc;
    private List<String> metaDoc;
    private List<String> bodyDoc;
    private List<String> h1Doc;
    private List<String> h2Doc;
    private List<String> h3Doc;
    private List<String> h4Doc;
    private List<String> h5Doc;
    private List<String> h6Doc;
    private List<String> codeDoc;
    private List<String> addressDoc;
    private List<String> summaryDoc;
    private List<String> blockquoteDoc;
    private List<String> markDoc;
    private List<String> insDoc;
    private List<String> mapDoc;
    private List<String> pDoc;
    private List<String> spanDoc;
    private List<String> divDoc;
    private List<String> ulDoc;
    private List<String> liDoc;
    private List<String> olDoc;
    private List<String> navDoc;
    private List<String> articleDoc;


    public EvaluatorServiceImpl() throws ParseException {
        eva = new Evaluator();
        getWeights();
        System.out.println("in constructor");

    }



    @Override
    public void getConsumedUrl(Url url)
    {
        this.url=url;
        getScore(this.url);

    }
    @Override
    public void htmlTag() {
        System.out.println("in html");
        long n = 0L;
        String htmlTag = docx.select("html").text();
        String[] str = htmlTag.toLowerCase().trim().split(" ");
        htmlDoc = Arrays.asList(str);

        //basics intent
        for (int j = 0; j < (basicsIndicatorTerms.length()); j++) {
            if (htmlDoc.contains(basicsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")))));
                indicatorVal[0] += (countOccurences(htmlDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")) - n) * basicsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("html");
            }
        }
        for (int j = 0; j < (basicsCounterIndicatorTerms.length()); j++) {
            if (htmlDoc.contains(basicsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent")))));
                counterIndicatorVal[0] += (countOccurences(htmlDoc, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) * basicsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("html");
            }
        }

        //tutorials intent
        for (int j = 0; j < tutorialsIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(tutorialsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")))));
                indicatorVal[1] += (countOccurences(htmlDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) - n) * tutorialsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("html");
            }
        }
        for (int j = 0; j < tutorialsCounterIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent")))));
                counterIndicatorVal[1] += (countOccurences(htmlDoc, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) * tutorialsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("html");
            }
        }

        //example  intent
        for (int j = 0; j < exampleIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(exampleIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")))));
                indicatorVal[2] += (countOccurences(htmlDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")) - n) * exampleIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("html");
            }
        }
        for (int j = 0; j < exampleCounterIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(exampleCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent")))));
                counterIndicatorVal[2] += (countOccurences(htmlDoc, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) * exampleCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("html");
            }
        }

        //complete reference intent
        for (int j = 0; j < completeReferenceIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(completeReferenceIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")))));
                indicatorVal[3] += (countOccurences(htmlDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) - n) * completeReferenceIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("html");
            }
        }
        for (int j = 0; j < completeReferenceCounterIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent")))));
                counterIndicatorVal[3] += (countOccurences(htmlDoc, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) * completeReferenceCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("html");
            }
        }

        //trouble shooting intent
        for (int j = 0; j < troubleShootingIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(troubleShootingIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")))));
                indicatorVal[4] += (countOccurences(htmlDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) - n) * troubleShootingIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("html");
            }

        }
        for (int j = 0; j < troubleShootingCounterIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")))));
                counterIndicatorVal[4] += (countOccurences(htmlDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) * troubleShootingCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("html");
            }
        }

        //gettingStarted
        for (int j = 0; j < gettingStartedIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(gettingStartedIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")))));
                indicatorVal[5] += (countOccurences(htmlDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) - n) * gettingStartedIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("html");
            }
        }
        for (int j = 0; j < gettingStartedCounterIndicatorTerms.length(); j++) {
            if (htmlDoc.contains(gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = ((countOccurences(headDoc, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(bodyDoc, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent")))));
                counterIndicatorVal[5] += (countOccurences(htmlDoc, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) * gettingStartedCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("html");

            }
        }
    }

    //Calculating scores for head tag
    @Override
    public void headTag() {
        long n = 0L;
        String headTag = docx.select("head").text();
        String[] str = headTag.toLowerCase().trim().split(" ");
        headDoc = Arrays.asList(str);

        //basics intent
        for (int j = 0; j < (basicsIndicatorTerms.length()); j++) {
            if (headDoc.contains(basicsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent"))));
                indicatorVal[0] += ((countOccurences(headDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")) - n > 0 ? (countOccurences(headDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * basicsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("head"));
            }
        }
        for (int j = 0; j < (basicsCounterIndicatorTerms.length()); j++) {
            if (headDoc.contains(basicsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent"))));
                counterIndicatorVal[0] += ((countOccurences(headDoc, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * basicsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("head");
            }
        }

        //tutorials intent
        for (int j = 0; j < tutorialsIndicatorTerms.length(); j++) {
            if (headDoc.contains(tutorialsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent"))));
                indicatorVal[1] += ((countOccurences(headDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * tutorialsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("head");
            }
        }
        for (int j = 0; j < tutorialsCounterIndicatorTerms.length(); j++) {
            if (headDoc.contains(tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent"))));
                counterIndicatorVal[1] += ((countOccurences(headDoc, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * tutorialsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("head");
            }
        }

        //example  intent
        for (int j = 0; j < exampleIndicatorTerms.length(); j++) {
            if (headDoc.contains(exampleIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent"))));
                indicatorVal[2] += ((countOccurences(headDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * exampleIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("head");
            }
        }
        for (int j = 0; j < exampleCounterIndicatorTerms.length(); j++) {
            if (headDoc.contains(exampleCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent"))));
                counterIndicatorVal[2] += ((countOccurences(headDoc, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * exampleCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("head");
            }
        }

        //complete reference intent
        for (int j = 0; j < completeReferenceIndicatorTerms.length(); j++) {
            if (headDoc.contains(completeReferenceIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent"))));
                indicatorVal[3] += ((countOccurences(headDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * completeReferenceIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("head");
            }
        }
        for (int j = 0; j < completeReferenceCounterIndicatorTerms.length(); j++) {
            if (headDoc.contains(completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent"))));
                counterIndicatorVal[3] += ((countOccurences(headDoc, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * completeReferenceCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("head");
            }
        }

        //trouble shooting intent
        for (int j = 0; j < troubleShootingIndicatorTerms.length(); j++) {
            if (headDoc.contains(troubleShootingIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent"))));
                indicatorVal[4] += ((countOccurences(headDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * troubleShootingIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("head");
            }
        }


        for (int j = 0; j < troubleShootingCounterIndicatorTerms.length(); j++) {
            if (headDoc.contains(troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent"))));
                counterIndicatorVal[4] += ((countOccurences(headDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * troubleShootingCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("head");
            }

        }

        //gettingStarted
        for (int j = 0; j < gettingStartedIndicatorTerms.length(); j++) {
            if (headDoc.contains(gettingStartedIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent"))));
                indicatorVal[5] += ((countOccurences(headDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * gettingStartedIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("head");
            }
        }
        for (int j = 0; j < gettingStartedCounterIndicatorTerms.length(); j++) {
            if (headDoc.contains(gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = (countOccurences(metaDoc, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent")) + (countOccurences(titleDoc, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent"))));
                counterIndicatorVal[5] += ((countOccurences(headDoc, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(headDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * gettingStartedCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("head");
            }
        }
    }

    //Calculating scores for title tag
    @Override
    public void titleTag() {
        titleDoc = Arrays.asList(docx.title().split(" "));
        calScore(titleDoc, "title");

    }

    //Calculating scores for meta tag
    @Override
    public void metaTag() {

        if (!docx.select("meta[name=description]").isEmpty()) {
            description = docx.select("meta[name=description]").get(0).attr("content");
        }
        //Get keywords from document object.
        if (!docx.select("meta[name=keywords]").isEmpty()) {
            keywords = docx.select("meta[name=keywords]").first().attr("content");
        }
        String string = description + keywords;
        String ss1 = string.trim().replaceAll(",", "");
        metaDoc = Arrays.asList(ss1.split(" "));

        calScore(metaDoc, "meta");
    }

    int bodyCal(String string) {
        int count = 0;
        count = countOccurences(h1Doc, string) + countOccurences(h2Doc, string) + countOccurences(h3Doc, string) + countOccurences(h4Doc, string) + countOccurences(h5Doc, string) +
                countOccurences(h6Doc, string) + countOccurences(codeDoc, string) + countOccurences(addressDoc, string) + countOccurences(summaryDoc, string) + countOccurences(blockquoteDoc, string) +
                countOccurences(markDoc, string) + countOccurences(insDoc, string) + countOccurences(mapDoc, string) + countOccurences(pDoc, string) + countOccurences(spanDoc, string) +
                countOccurences(divDoc, string) + countOccurences(ulDoc, string) + countOccurences(olDoc, string) + countOccurences(articleDoc, string) + countOccurences(navDoc, string);
        return count;
    }

    //Calculating scores for body tag
    @Override
    public void bodyTag() {
        if (!docx.select("body").isEmpty()) {
            long n = 0L;
            String bodyTag = docx.select("body").text();
            String ss = bodyTag.toLowerCase().trim().replaceAll(":", "");
            String ss1 = ss.trim().replaceAll(",", "");
            String[] str1 = ss1.split(" ");
            bodyDoc = Arrays.asList(str1);

            for (int j = 0; j < (basicsIndicatorTerms.length()); j++) {
                try {
                    if (bodyDoc.contains(basicsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(basicsIndicatorTerms.getJSONObject(j).getString("intent"));
                        indicatorVal[0] += ((countOccurences(bodyDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * basicsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex) {
                    continue;
                }
            }

            for (int j = 0; j < (basicsCounterIndicatorTerms.length()); j++) {
                try {
                    if (bodyDoc.contains(basicsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(basicsCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                        counterIndicatorVal[0] += ((countOccurences(bodyDoc, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * basicsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("body");

                    }
                } catch (NullPointerException ex) {
                    continue;
                }
            }

            //tutorials intent

            for (int j = 0; j < tutorialsIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(tutorialsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(tutorialsIndicatorTerms.getJSONObject(j).getString("intent"));
                        indicatorVal[1] += ((countOccurences(bodyDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * tutorialsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }
            for (int j = 0; j < tutorialsCounterIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                        counterIndicatorVal[1] += ((countOccurences(bodyDoc, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * tutorialsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }


            //example  intent
            for (int j = 0; j < exampleIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(exampleIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(exampleIndicatorTerms.getJSONObject(j).getString("intent"));
                        indicatorVal[2] += ((countOccurences(bodyDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * exampleIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }
            for (int j = 0; j < exampleCounterIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(exampleCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(exampleCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                        counterIndicatorVal[2] += ((countOccurences(bodyDoc, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * exampleCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }

            //complete reference intent
            for (int j = 0; j < completeReferenceIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(completeReferenceIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(completeReferenceIndicatorTerms.getJSONObject(j).getString("intent"));
                        indicatorVal[3] += ((countOccurences(bodyDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * completeReferenceIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }
            for (int j = 0; j < completeReferenceCounterIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                        counterIndicatorVal[3] += ((countOccurences(bodyDoc, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * completeReferenceCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }

            //trouble shooting intent
            for (int j = 0; j < troubleShootingIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(troubleShootingIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(troubleShootingIndicatorTerms.getJSONObject(j).getString("intent"));
                        indicatorVal[4] += ((countOccurences(bodyDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * troubleShootingIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }

            for (int j = 0; j < troubleShootingCounterIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                        counterIndicatorVal[4] += ((countOccurences(bodyDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * troubleShootingCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }


            //gettingStarted
            for (int j = 0; j < gettingStartedIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(gettingStartedIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(gettingStartedIndicatorTerms.getJSONObject(j).getString("intent"));
                        indicatorVal[5] += ((countOccurences(bodyDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * gettingStartedIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }

            for (int j = 0; j < gettingStartedCounterIndicatorTerms.length(); j++) {
                try {
                    if (bodyDoc.contains(gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                        n = bodyCal(gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                        counterIndicatorVal[5] += ((countOccurences(bodyDoc, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(bodyDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * gettingStartedCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get("body");
                    }
                } catch (NullPointerException ex){
                    continue;
                }
            }
        }
    }

    //Calculating scores for h1 tag
    @Override
    public void h1Tag() {
        String h1Tag="";
        String[] str;
        if(!docx.select("h1").isEmpty()){
            h1Tag = docx.select("h1").first().text();
            str = h1Tag.toLowerCase().trim().split(" ");
            h1Doc = Arrays.asList(str);
            calScore(h1Doc, "h1");
        }


    }

    //Calculating scores for h2 tag
    @Override
    public void h2Tag() {
        String h2Tag;
        String[] str;
        if(!docx.select("h2").isEmpty()) {
            h2Tag = docx.select("h2").text();
            str = h2Tag.toLowerCase().trim().split(" ");
            h2Doc = Arrays.asList(str);

            calScore(h2Doc, "h2");
        }
    }

    //Calculating scores for h3 tag
    @Override
    public void h3Tag() {
        String h3Tag;
        String[] str;
        if(!docx.select("h3").text().isEmpty()){
            h3Tag = docx.select("h3").text();
            str= h3Tag.toLowerCase().trim().split(" ");
            h3Doc = Arrays.asList(str);
            calScore(h3Doc, "h3");
        }
    }


    //Calculating scores for h4 tag
    @Override
    public void h4Tag() {
        if(!docx.select("h4").text().isEmpty()) {
            String h4Tag = docx.select("h4").text();
            String[] str = h4Tag.toLowerCase().trim().split(" ");
            h4Doc = Arrays.asList(str);

            calScore(h4Doc, "h4");
        }
    }

    //Calculating scores for h5 tag
    @Override
    public void h5Tag() {
        if(!docx.select("h5").text().isEmpty()){
            String h5Tag = docx.select("h5").text();
            String[] str = h5Tag.toLowerCase().trim().split(" ");
            h5Doc = Arrays.asList(str);
            calScore(h5Doc, "h5");
        }

    }

    //Calculating scores for h6 tag
    @Override
    public void h6Tag() {
        if(!docx.select("h6").text().isEmpty()) {
            String h6Tag = docx.select("h6").text();
            String[] str = h6Tag.toLowerCase().trim().split(" ");
            h6Doc = Arrays.asList(str);
            calScore(h6Doc, "h6");
        }
    }

    //Calculating scores for code tag
    @Override
    public void codeTag() {
        if(!docx.select("code").text().isEmpty()) {
            String codeTag = docx.select("code").text();
            String ss = codeTag.toLowerCase().trim().replaceAll(":", "");
            String ss1 = ss.trim().replaceAll(",", "");
            String[] str1 = ss1.split(" ");
            codeDoc = Arrays.asList(str1);

            calScore(codeDoc, "code");
        }
    }

    //Calculating scores for address tag
    @Override
    public void addressTag() {
        if(!docx.select("address").text().isEmpty()) {
            String addressTag = docx.select("address").text();
            String ss = addressTag.toLowerCase().trim().replaceAll(":", "");
            String ss1 = ss.trim().replaceAll(",", "");
            String[] str1 = ss1.split(" ");
            addressDoc = Arrays.asList(str1);
            calScore(addressDoc, "address");
        }
    }

    //Calculating scores for summary tag
    @Override
    public void summaryTag() {
        if(!docx.select("summary").isEmpty()) {
            String summaryTag = docx.select("summary").text();
            String ss = summaryTag.toLowerCase().trim().replaceAll(":", "");
            String ss1 = ss.trim().replaceAll(",", "");
            String[] str1 = ss1.split(" ");
            summaryDoc = Arrays.asList(str1);
            calScore(summaryDoc, "summary");
        }
    }

    //Calculating scores for blockquote tag
    @Override
    public void blockQuoteTag() {
        if(!docx.select("blockquote").isEmpty()) {
            String blockQuoteTag = docx.select("blockquote").text();
            String[] str = blockQuoteTag.toLowerCase().trim().split(" ");
            blockquoteDoc = Arrays.asList(str);
            calScore(blockquoteDoc, "blockquote");
        }
    }

    //Calculating scores for mark tag
    @Override
    public void markTag() {
        if(!docx.select("mark").isEmpty()) {
            String markTag = docx.select("mark").text();
            String[] str = markTag.toLowerCase().trim().split(" ");
            markDoc = Arrays.asList(str);
            calScore(markDoc, "mark");
        }

    }

    //Calculating scores for ins tag
    @Override
    public void insTag() {
        if(!docx.select("ins").isEmpty()) {
            String insTag = docx.select("ins").text();
            String[] str = insTag.toLowerCase().trim().split(" ");
            insDoc = Arrays.asList(str);
            calScore(insDoc, "ins");
        }
    }

    //Calculating scores for map tag
    @Override
    public void mapTag() {
        if(!docx.select("map").isEmpty()) {
            String mapTag = docx.select("map").text();
            String[] str = mapTag.toLowerCase().trim().split(" ");
            mapDoc = Arrays.asList(str);
            calScore(mapDoc, "map");
        }
    }

    //Calculating scores for p tag
    @Override
    public void pTag() {
        if(!docx.select("p").isEmpty()){
            String ss = docx.select("p").text().toLowerCase().trim().replaceAll(":", "");
            String ss1 = ss.trim().replaceAll(",", "");
            String[] str1 = ss1.split(" ");
            pDoc = Arrays.asList(str1);
            calScore(pDoc, "p");
        }
    }

    //Calculating scores for span tag
    @Override
    public void spanTag() {
        if(!docx.select("span").isEmpty()) {
            String spanTag = docx.select("span").text();
            String[] str = spanTag.toLowerCase().trim().split(" ");
            spanDoc = Arrays.asList(str);
            calScore(spanDoc, "span");
        }
    }

    //Calculating scores for div tag
    @Override
    public void divTag() {
        if(!docx.select("div").isEmpty()) {
            String divTag = docx.select("div").text();
            String ss = divTag.toLowerCase().trim().replaceAll(":", "");
            String ss1 = ss.trim().replaceAll(",", "");
            String[] str1 = ss1.split(" ");
            divDoc = Arrays.asList(str1);
            calScore(divDoc, "div");
        }
    }

    //Calculating scores for li tag
    @Override
    public void liTag() {
        if(!docx.select("li").isEmpty()) {
            String liTag = docx.select("li").text();
            String[] str = liTag.toLowerCase().trim().split(" ");
            liDoc = Arrays.asList(str);
            calScore(liDoc, "li");
        }
    }

    //Calculating scores for ul tag
    @Override
    public void ulTag() {
        if(!docx.select("ul").isEmpty()) {
            String ulTag = docx.select("ul").text();
            String[] str = ulTag.toLowerCase().trim().split(" ");
            ulDoc = Arrays.asList(str);
            calScoreOne(ulDoc, "ul");
        }
    }


    //Calculating scores for ol tag
    @Override
    public void olTag() {
        if (!docx.select("ol").isEmpty()) {
            String olTag = docx.select("ol").text();
            String[] str = olTag.toLowerCase().trim().split(" ");
            olDoc = Arrays.asList(str);
            calScoreOne(olDoc, "ol");
        }
    }


    //Calculating scores for article tag
    @Override
    public void articleTag() {
        if(!docx.select("article").isEmpty()) {
            String articleTag = docx.select("article").text();
            String[] str = articleTag.toLowerCase().trim().split(" ");
            articleDoc = Arrays.asList(str);
            calScore(articleDoc, "article");
        }
    }

    //Calculating scores for nav tag
    @Override
    public void navTag() {
        if(!docx.select("nav").isEmpty()) {
            String navTag = docx.select("nav").text();
            String[] str = navTag.toLowerCase().trim().split(" ");
            navDoc = Arrays.asList(str);
            calScore(navDoc, "nav");
        }
    }


    public int countOccurences(List<String> str, String strL) {
        int countx = 0;
        if(!strL.isEmpty()) {

            for (String s : str) {
                if (s.trim().equals(strL)) {
                    countx++;

                }
            }

        }
        return countx;
    }

    public int countOccurencesOne(List<String> str, List<String> strL) {
        int countx = 0;
        for (String s : str) {
            if (strL.contains(s.trim())) {
                countx++;
            }
        }
        return countx;

    }

    void calScoreOne(List<String> str, String tag) {
        long n = 0L;
        for (int j = 0; j < (basicsIndicatorTerms.length()); j++) {
            if (str.contains(basicsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, basicsIndicatorTerms.getJSONObject(j).getString("intent"));
                indicatorVal[0] += ((countOccurences(str, basicsIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, basicsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * basicsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);
            }
        }
        for (int j = 0; j < (basicsCounterIndicatorTerms.length()); j++) {
            if (str.contains(basicsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                counterIndicatorVal[0] += ((countOccurences(str, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * basicsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);

            }
        }

        //tutorials intent
        for (int j = 0; j < tutorialsIndicatorTerms.length(); j++) {
            if (str.contains(tutorialsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, tutorialsIndicatorTerms.getJSONObject(j).getString("intent"));
                indicatorVal[1] += ((countOccurences(str, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * tutorialsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);
            }
        }

        for (int j = 0; j < tutorialsCounterIndicatorTerms.length(); j++) {
            if (str.contains(tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                counterIndicatorVal[1] += ((countOccurences(str, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * tutorialsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);
            }
        }


        //example  intent
        for (int j = 0; j < exampleIndicatorTerms.length(); j++) {
            if (str.contains(exampleIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, exampleIndicatorTerms.getJSONObject(j).getString("intent"));
                indicatorVal[2] += (((countOccurences(str, exampleIndicatorTerms.getJSONObject(j).getString("intent"))) - n) > 0 ? (countOccurences(str, exampleIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * exampleIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);
            }
        }
        for (int j = 0; j < exampleCounterIndicatorTerms.length(); j++) {
            if (str.contains(exampleCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                counterIndicatorVal[2] += ((countOccurences(str, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * exampleCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }

        //complete reference intent
        for (int j = 0; j < completeReferenceIndicatorTerms.length(); j++) {
            if (str.contains(completeReferenceIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent"));
                indicatorVal[3] += ((countOccurences(str, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * completeReferenceIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }
        for (int j = 0; j < completeReferenceCounterIndicatorTerms.length(); j++) {
            if (str.contains(completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                counterIndicatorVal[3] += ((countOccurences(str, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * completeReferenceCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }

        //trouble shooting intent
        for (int j = 0; j < troubleShootingIndicatorTerms.length(); j++) {
            if (str.contains(troubleShootingIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent"));
                indicatorVal[4] += ((countOccurences(str, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * troubleShootingIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }

        for (int j = 0; j < troubleShootingCounterIndicatorTerms.length(); j++) {
            if (str.contains(troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                counterIndicatorVal[4] += ((countOccurences(str, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * troubleShootingCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }

        //gettingStarted
        for (int j = 0; j < gettingStartedIndicatorTerms.length(); j++) {
            if (str.contains(gettingStartedIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent"));
                indicatorVal[5] += ((countOccurences(str, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * gettingStartedIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }
        for (int j = 0; j < gettingStartedCounterIndicatorTerms.length(); j++) {
            if (str.contains(gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                n = countOccurences(liDoc, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent"));
                counterIndicatorVal[5] += ((countOccurences(str, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) > 0 ? (countOccurences(str, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent")) - n) : 0) * gettingStartedCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }
    }

    void calScore(List<String> str, String tag) {
        for (int j = 0; j < (basicsIndicatorTerms.length()); j++) {
            if (str.contains(basicsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                indicatorVal[0] += countOccurences(str, basicsIndicatorTerms.getJSONObject(j).getString("intent")) * basicsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);
            }
        }
        for (int j = 0; j < (basicsCounterIndicatorTerms.length()); j++) {
            if (str.contains(basicsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                counterIndicatorVal[0] += countOccurences(str, basicsCounterIndicatorTerms.getJSONObject(j).getString("intent")) * basicsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);
            }
        }

        //tutorials intent
        for (int j = 0; j < tutorialsIndicatorTerms.length(); j++) {
            if (str.contains(tutorialsIndicatorTerms.getJSONObject(j).getString("intent"))) {
                indicatorVal[1] += countOccurences(str, tutorialsIndicatorTerms.getJSONObject(j).getString("intent")) * tutorialsIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);
            }
        }
        for (int j = 0; j < tutorialsCounterIndicatorTerms.length(); j++) {
            if (str.contains(tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                counterIndicatorVal[1] += countOccurences(str, tutorialsCounterIndicatorTerms.getJSONObject(j).getString("intent")) * tutorialsCounterIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);
            }
        }


        //example  intent
        for (int j = 0; j < exampleIndicatorTerms.length(); j++) {
            if (str.contains(exampleIndicatorTerms.getJSONObject(j).getString("intent"))) {
                indicatorVal[2] += countOccurences(str, exampleIndicatorTerms.getJSONObject(j).getString("intent")) * exampleIndicatorTerms.getJSONObject(j).getLong("intensity") * tagweight.get(tag);
            }
        }
        for (int j = 0; j < exampleCounterIndicatorTerms.length(); j++) {
            if (str.contains(exampleCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                counterIndicatorVal[2] += countOccurences(str, exampleCounterIndicatorTerms.getJSONObject(j).getString("intent")) * exampleCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }

        //complete reference intent
        for (int j = 0; j < completeReferenceIndicatorTerms.length(); j++) {
            if (str.contains(completeReferenceIndicatorTerms.getJSONObject(j).getString("intent"))) {
                indicatorVal[3] += countOccurences(str, completeReferenceIndicatorTerms.getJSONObject(j).getString("intent")) * completeReferenceIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }
        for (int j = 0; j < completeReferenceCounterIndicatorTerms.length(); j++) {
            if (str.contains(completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                counterIndicatorVal[3] += countOccurences(str, completeReferenceCounterIndicatorTerms.getJSONObject(j).getString("intent")) * completeReferenceCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }
        //trouble shooting intent
        for (int j = 0; j < troubleShootingIndicatorTerms.length(); j++) {
            if (str.contains(troubleShootingIndicatorTerms.getJSONObject(j).getString("intent"))) {
                indicatorVal[4] += countOccurences(str, troubleShootingIndicatorTerms.getJSONObject(j).getString("intent")) * troubleShootingIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }

        for (int j = 0; j < troubleShootingCounterIndicatorTerms.length(); j++) {
            if (str.contains(troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                counterIndicatorVal[4] += countOccurences(str, troubleShootingCounterIndicatorTerms.getJSONObject(j).getString("intent")) * troubleShootingCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }


        //gettingStarted
        for (int j = 0; j < gettingStartedIndicatorTerms.length(); j++) {
            if (str.contains(gettingStartedIndicatorTerms.getJSONObject(j).getString("intent"))) {
                indicatorVal[5] += countOccurences(str, gettingStartedIndicatorTerms.getJSONObject(j).getString("intent")) * gettingStartedIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }
        }
        for (int j = 0; j < gettingStartedCounterIndicatorTerms.length(); j++) {
            if (str.contains(gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent"))) {
                counterIndicatorVal[5] += countOccurences(str, gettingStartedCounterIndicatorTerms.getJSONObject(j).getString("intent")) * gettingStartedCounterIndicatorTerms.getJSONObject(j).getInt("intensity") * tagweight.get(tag);
            }

        }
    }


    //calculate confidence score and level and return json object
    @Override
    public Evaluator getScore(Url url) {
        evalcount++;
        this.docx = Jsoup.parse(url.getDoc());
        long[][] val = new long[26][4];
        Float[] score = new Float[6];
        Float[] scoren = new Float[6];
        DecimalFormat df2 = new DecimalFormat(".##");
        for (int i = 0; i < 6; i++) {
            indicatorVal[i] = 0;
            counterIndicatorVal[i] = 0;
        }
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
        liTag();
        ulTag();
        olTag();
        articleTag();
        navTag();
        bodyTag();
        metaTag();
        titleTag();
        headTag();
        htmlTag();

        for (int i = 0; i < 6; i++) {
            if ((indicatorVal[i] + counterIndicatorVal[i]) <= 0) {
                score[i] = 0F;
            } else {

                score[i] = ((float) (indicatorVal[i])) / (indicatorVal[i] + counterIndicatorVal[i]);
                scoren[i] = Float.parseFloat(df2.format(score[i]));
            }
        }

        float max = 0;
        int level = 0;

        for (int i = 0; i < scoren.length; i++) {
            try {
                System.out.println(scoren[i]);
                if (scoren[i] > max) {
                    level = i;
                    max = scoren[i];

                }
            } catch (NullPointerException e) {
                continue;
            }
        }

        this.eva.setUrl(url.getUrl());
        this.eva.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
        this.eva.setDomain(url.getDomain());
        this.eva.setConcept(url.getConcept());
        this.eva.setConfidenceScore(max);
        this.eva.setLevel(levels[level]);
        this.eva.setDescription(description);
        this.eva.setKeywords(keywords);
        this.eva.setTitle(this.docx.title());
        //rabbitmq sender
        rabbitMQSender.send(this.eva);
       /* if (evalcount==RabbitMQListner.counter){
            rabbitMQSender.inform();
        }
        else {
            System.out.println("inform not working");
        }*/
        System.out.print(this.eva);
        return this.eva;
    }

    //get weights from tagweight.json
    @Override
    public void getWeights() throws ParseException {
        File file = new File("./assets/tagweights.json");

        try {

            FileReader fileReader = new FileReader(file);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fileReader);

            JSONObject jsonObj = new JSONObject((HashMap) obj);

            tagweight.putAll((Map<? extends String, ? extends Long>) obj);

            FileReader fileReaderData = new FileReader("./assets/data.json");

            JSONParser parserData = new JSONParser();
            Object objData = parserData.parse(fileReaderData);
            JSONObject jsonObjData = new JSONObject((HashMap) objData);

            JSONObject jsonK = (JSONObject) jsonObjData.get("basics");
            JSONObject jsonC = (JSONObject) jsonObjData.get("tutorials");
            JSONObject jsonApp = (JSONObject) jsonObjData.get("example");
            JSONObject jsonAna = (JSONObject) jsonObjData.get("completeReference");
            JSONObject jsonS = (JSONObject) jsonObjData.get("troubleShooting");
            JSONObject jsonE = (JSONObject) jsonObjData.get("gettingStarted");

            basicsIndicatorTerms = jsonK.getJSONArray("indicator");
            tutorialsIndicatorTerms = jsonC.getJSONArray("indicator");
            exampleIndicatorTerms = jsonApp.getJSONArray("indicator");
            completeReferenceIndicatorTerms = jsonAna.getJSONArray("indicator");
            troubleShootingIndicatorTerms = jsonS.getJSONArray("indicator");
            gettingStartedIndicatorTerms = jsonE.getJSONArray("indicator");


            basicsCounterIndicatorTerms = jsonK.getJSONArray("counterIndicator");
            tutorialsCounterIndicatorTerms = jsonC.getJSONArray("counterIndicator");
            exampleCounterIndicatorTerms = jsonApp.getJSONArray("counterIndicator");
            completeReferenceCounterIndicatorTerms = jsonAna.getJSONArray("counterIndicator");
            troubleShootingCounterIndicatorTerms = jsonS.getJSONArray("counterIndicator");
            gettingStartedCounterIndicatorTerms = jsonE.getJSONArray("counterIndicator");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}