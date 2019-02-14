package com.stackroute.plasma.controller;


import com.stackroute.plasma.service.NlpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NlpController {
    @Autowired
    NlpServiceImpl nlpService;

    public List<String> extractedQuery(@RequestBody final String query) {

        nlpService.queryConverter(query);
        return null;
    }





    //    @PostMapping("/lemmatoken")
//    public List<String> convertToLemma(@RequestBody final String input) {
//        CoreDocument coreDocument = new CoreDocument(input);
//        stanfordCoreNLP.annotate(coreDocument);
//        // System.out.println(stopWord.getList());
//        List<CoreLabel> coreLabels = coreDocument.tokens();
//        String lemma;
//        List<String> finalString = new ArrayList<>();
//        HashSet<String> word;
//        word = stopWord.readfile();
//        System.out.println(word);
//        for (CoreLabel coreLabel: coreLabels
//        ) {
//            lemma = coreLabel.lemma();
//            if (!(word.contains(lemma))) {
//                System.out.println("goooood");
//                System.out.println(lemma);
//                finalString.add(lemma);
//            }
//            // finalString.add(lemma);
//            // System.out.println(lemma);
//        }
//        // return coreLabels.stream().map(CoreLabel::originalText).collect(Collectors.toList());
//        return finalString.stream().map(String::toString).collect(Collectors.toList());
//    }
}
