package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Evaluator;
import com.stackroute.plasma.domain.Url;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface EvaluatorService {

    Evaluator getScore();
    void getConsumedUrl(Url url);
    void getWeights() throws IOException, ParseException;
    void htmlTag();
    void headTag();
    void titleTag();
    void metaTag();
    void bodyTag();
    void h1Tag();
    void h2Tag();
    void h3Tag();
    void h4Tag();
    void h5Tag();
    void h6Tag();
    void codeTag();
    void addressTag();
    void summaryTag();
    void blockQuoteTag();
    void markTag();
    void insTag();
    void mapTag();
    void pTag();
    void spanTag();
    void divTag();
    void liTag();
    void ulTag();
    void olTag();
    void articleTag();
    void navTag();

}