package com.stackroute.documentcrawler.domain;

import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;

import java.sql.Timestamp;

@NoArgsConstructor
public class Url {

    private String url;
    private String concept;
    private String domain;
    private String doc;
    private Timestamp timestamp;

    public Url(String url, String concept, String domain, String doc, Timestamp timestamp) {
        this.url = url;
        this.concept = concept;
        this.domain = domain;
        this.doc = doc;
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public String getConcept() {
        return concept;
    }

    public String getDomain() {
        return domain;
    }

    public String getDoc() {
        return doc;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
    //    public String getConcept() {
//        return concept;
//    }
//
//    public void setConcept(String concept) {
//        this.concept = concept;
//    }
//
//    public String getDomain() {
//        return domain;
//    }
//
//    public void setDomain(String domain) {
//        this.domain = domain;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public void  setDoc(Document doc)
//    {
//        this.doc =  doc;
//    }

    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                ", concept='" + concept + '\'' +
                ", domain='" + domain + '\'' +
                ", doc=" + doc +
                '}';
    }
}
