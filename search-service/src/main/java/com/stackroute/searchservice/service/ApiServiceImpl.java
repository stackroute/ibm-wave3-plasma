package com.stackroute.searchservice.service;

import com.stackroute.searchservice.domain.SearchStorage;
import com.stackroute.searchservice.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class ApiServiceImpl implements ApiService {

    final static String apiKey = "AIzaSyB-93tpPyxrK76l6iw-mFnsvDiUJCLpFw8";
    final static String customSearchEngineKey = "006477474756235376421:nz2modhy5qa";
    public String newResult ;
    private int initial;
    String[] link;
    @Autowired
    SearchRepository searchRepository;
    public ApiServiceImpl() {
    }
    int k = 0;

    final static String searchURL = "https://www.googleapis.com/customsearch/v1?";

    @Override
    public SearchStorage save(SearchStorage searchStorage) {
        return searchRepository.save(searchStorage);
    }

    public String[] getConceptsUrl(String qSearch, int start, int numOfResults) {
        int iter = 0;
        link = new String[10];
        int i = 0;
        while (iter++<2) {
            try {
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


                        if (parser.getString().equals("link")) {
                            System.out.println("reason");
                            JsonParser.Event value = parser.next();

                            if (value == JsonParser.Event.VALUE_STRING){
                                System.out.println("inside json");
                                link[i++] = parser.getString();
                                //System.out.println(link[i++]);
                            }
                        }

                    }

                }
                k = k + 1;
                initial = initial + 10;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return link;
    }

}