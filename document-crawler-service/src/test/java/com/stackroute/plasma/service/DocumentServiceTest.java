//
//package com.stackroute.plasma.service;
//
//
//import com.stackroute.plasma.domain.SearchOutput;
//import com.stackroute.plasma.domain.Url;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
//import static org.junit.Assert.*;
//
//public class DocumentServiceTest {
//
//
//    DocumentServiceTest documentServiceTest;
//    SearchOutput searchOutput=new SearchOutput();
//    DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();
//    Url url=new Url();
//
//
//
//
//
//
//    @Autowired
//    public DocumentServiceTest() throws IOException {
//    }
//
//
//
//
//    @Before
//    public void setUp() throws Exception {
//        documentServiceTest = new DocumentServiceTest();
////        url.setUrl("http://www.dustyfeet.com/");
//      this.url.setUrl("https://www.youtube.com/watch?v=szYzBC89CPE");
//
//      this.url.setTimestamp(String.valueOf(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now()))));
//        this.url.setDomain("java");
//        this.url.setConcept("abstraction");
//        this.url.setDoc("sfakfjkafj");
//        this.searchOutput.setUrls(new String[]{"https://www.youtube.com/watch?v=szYzBC89CPE","https://beginnersbook.com/2013/03/oops-in-java-encapsulation-inheritance-polymorphism-abstraction/",
//                "https://www.youtube.com/watch?v=PM47JJe_8xI",
//                "https://dzone.com/articles/java-encapsulation-for-adults",
//                "https://howtodoinjava.com/oops/encapsulation-in-java-and-its-relation-with-abstraction/",
//                "https://www.guru99.com/java-oops-encapsulation.html",
//                "https://programmingstack.com/java-encapsulation.html",
//                "https://quizlet.com/177452001/java-encapsulation-flash-cards/",
//                "https://www.coursehero.com/file/14011464/Java-encapsulation-inheritance-polymorphism/",
//                "https://quizlet.com/332830793/java-encapsulationscope-quiz-flash-cards/"});
//
//
//        this.searchOutput.setTimestamp(String.valueOf(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now()))));
//        this.searchOutput.setDomain("java");
//        this.searchOutput.setConcept("abstraction");
//    }
//
//
//
//
//    @Test
//    public void getDoc() throws IOException {
//
//
//        assertNotNull(documentServiceImpl.getHtml());
//
//
//    }
//
//
//}
//
