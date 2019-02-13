package com.stackroute.plasma.service;

import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class GoogleApiSearchService {
    final static String apiKey = "AIzaSyB-93tpPyxrK76l6iw-mFnsvDiUJCLpFw8";
    final static String customSearchEngineKey = "006477474756235376421:nz2modhy5qa";

    // base url for the search query
    final static String searchURL = "https://www.googleapis.com/customsearch/v1?";
    //https://cse.google.com/cse/setup/basic?cx=006477474756235376421%3Anz2modhy5qa
    //https://console.developers.google.com/apis/credentials?project=plasma-231517

    public  String read(String qSearch, int start, int numOfResults) {
        try {

            String toSearch = searchURL + "key=" + apiKey + "&cx="
                    + customSearchEngineKey + "&q=";

            toSearch += qSearch;

            toSearch += "&alt=json";

            toSearch += "&start=" + start;

            toSearch += "&num=" + numOfResults;

            URL url = new URL(toSearch);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
