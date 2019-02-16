package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.Api;
import com.stackroute.plasma.service.GoogleApiSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.StringReader;

@RestController
@RequestMapping("api/v1")
public class GoogleApiSearchController {
    @Autowired
    GoogleApiSearchService googleApiSearchService;
    Api api = new Api();
    String newConcepts[] = api.getConcepts();
    public String result;
    private int initial;
    private int finall;
    @GetMapping("/search")
    public String getApi(){
        //for(int i=0;i<10;i++)

        result = googleApiSearchService.read(api.getDomain()+newConcepts[1], 1, 10);
        System.out.println("hello");
        System.out.println(result);
//        JsonParser parser = Json.createParser(new StringReader(result));
//        while (parser.hasNext()) {
//            JsonParser.Event event = parser.next();
//
//            if (event == JsonParser.Event.KEY_NAME) {
//
//                if (parser.getString().equals("htmlTitle")) {
//                    JsonParser.Event value = parser.next();
//
//                    if (value == JsonParser.Event.VALUE_STRING)
//                        System.out.println("Title (HTML): "
//                                + parser.getString());
//                }
//
//                if (parser.getString().equals("link")) {
//
//                    JsonParser.Event value = parser.next();
//
//                    if (value == JsonParser.Event.VALUE_STRING)
//                        System.out.println("Link: " + parser.getString());
//                }
//
//            }
//
//        }
//
//        initial = initial + 10;
//
//        finall++;
//
//        System.out
//                .println("**************************************************");
//
//        return result;
        return result;
    }
}
