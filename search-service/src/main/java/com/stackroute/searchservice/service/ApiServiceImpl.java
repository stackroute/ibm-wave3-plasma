package com.stackroute.searchservice.service;

import org.springframework.stereotype.Service;
import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


@Service
public class ApiServiceImpl implements ApiService {
    final static String apiKey = "AIzaSyB-93tpPyxrK76l6iw-mFnsvDiUJCLpFw8";
    final static String customSearchEngineKey = "006477474756235376421:nz2modhy5qa";
    //final static String apiKey = "AIzaSyBN_QAEUoj4ESI36Qa8auyZYYfyZuPooMw";
    //final static String apiKey = "AIzaSyBhvtnE8z6YE2Pqvzl7SNntHoslhjWxoKs";
  //  final static String customSearchEngineKey = "004545419840463440212:tgrsnlvihi4";

    public String newResult ;
    private int initial;
    String[] link;
    //String[] linkNew;
    //ArrayList<String[]> xxx;
    public ApiServiceImpl() {
    }

    //writing cudtom output extraaaaa
    //SearchInput searchInput = new SearchInput();

    int k = 0;
    //int iter = 0;
    //private int finall;
    // base url for the search query
    final static String searchURL = "https://www.googleapis.com/customsearch/v1?";
    //https://cse.google.com/cse/setup/basic?cx=006477474756235376421%3Anz2modhy5qa
    //https://console.developers.google.com/apis/credentials?project=plasma-231517
//method to read call api

    public String[] getConceptsUrl(String qSearch, int start, int numOfResults) {
        //xxx = new ArrayList<>();
        int iter = 0;
        link = new String[100];
        int i = 0;
        while (iter++<10) {
           // linkNew = new String[10];
            try {
                //int i = 0;
                //link = new String[10];

                String toSearch = searchURL + "key=" + apiKey + "&cx="
                        + customSearchEngineKey + "&q=";

                toSearch += qSearch;

                toSearch += "&alt=json";

                toSearch += "&start=" + start;

                toSearch += "&num=" + numOfResults;

                URL url = new URL(toSearch);
                System.out.println("check1");
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                System.out.println("check2");
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line;
                StringBuffer buffer = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    buffer.append(line);
                }
                newResult = buffer.toString();
                JsonParser parser = Json.createParser(new StringReader(newResult));
                while (parser.hasNext()) {
                    JsonParser.Event event = parser.next();

                    if (event == JsonParser.Event.KEY_NAME) {

//                    if (parser.getString().equals("htmlTitle")) {
//                        JsonParser.Event value = parser.next();
//                        if (value == JsonParser.Event.VALUE_STRING){
//
//                        }
////                            System.out.println("Title (HTML): "
////                                    + parser.getString());
//                    }

                        if (parser.getString().equals("link")) {
                            System.out.println("reason");
                            JsonParser.Event value = parser.next();

                            if (value == JsonParser.Event.VALUE_STRING){
                                System.out.println("inside json");
                                link[i++] = parser.getString();
                              //  System.out.println("Link: " + parser.getString());
                               // xxx.add(link);
                                //searchOutput[k].setUrls();
                            }
                            //link[i++] = parser.getString();
                           // System.out.println("Link: " + parser.getString());
                        }

                    }

                }
                k = k + 1;
                initial = initial + 10;
                //finall++;
//            System.out
//                    .println("**************************************************");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //linkNew = linkNew + link;
            //iter++;




        }



//        try {
//            int i = 0;
//            link = new String[10];
//            String toSearch = searchURL + "key=" + apiKey + "&cx="
//                    + customSearchEngineKey + "&q=";
//
//            toSearch += qSearch;
//
//            toSearch += "&alt=json";
//
//            toSearch += "&start=" + start;
//
//            toSearch += "&num=" + numOfResults;
//
//            URL url = new URL(toSearch);
//            HttpURLConnection connection = (HttpURLConnection) url
//                    .openConnection();
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    connection.getInputStream()));
//            String line;
//            StringBuffer buffer = new StringBuffer();
//            while ((line = br.readLine()) != null) {
//                buffer.append(line);
//            }
//            newResult = buffer.toString();
//            JsonParser parser = Json.createParser(new StringReader(newResult));
//            while (parser.hasNext()) {
//                JsonParser.Event event = parser.next();
//
//                if (event == JsonParser.Event.KEY_NAME) {
//
////                    if (parser.getString().equals("htmlTitle")) {
////                        JsonParser.Event value = parser.next();
////                        if (value == JsonParser.Event.VALUE_STRING){
////
////                        }
//////                            System.out.println("Title (HTML): "
//////                                    + parser.getString());
////                    }
//
//                    if (parser.getString().equals("link")) {
//
//                        JsonParser.Event value = parser.next();
//
//                        if (value == JsonParser.Event.VALUE_STRING){
//                            link[i++] = parser.getString();
//                            //searchOutput[k].setUrls();
//                        }
//                            //link[i++] = parser.getString();
//                        //System.out.println("Link: " + parser.getString());
//                    }
//
//                }
//
//            }
//            k = k + 1;
//            initial = initial + 10;
//            //finall++;
////            System.out
////                    .println("**************************************************");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return link;
    }

}
