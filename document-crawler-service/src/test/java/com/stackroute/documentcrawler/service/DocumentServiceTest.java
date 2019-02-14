//package com.stackroute.documentcrawler.service;
//
//import com.stackroute.documentcrawler.domain.Url;
//import org.junit.Before;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class DocumentServiceTest {
//    Url url;
//
//
//
//
//    //Inject the mocks as dependencies into UserServiceImpl
//    @InjectMocks
//    DocumentServiceImpl documentService;
//    List<Url> list= null;
//
//
//    @Before
//    public void setUp(){
//        //Initialising the mock object
//        MockitoAnnotations.initMocks(this);
//        url = new Url();
//        url.setConcept("class");
//        url.setDomain("java");
//        url.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
//        url.setUrl("http://www.microscopy-uk.org.uk/mag/indexmag.html?http://www.microscopy-uk.org.uk/mag/wimsmall/smal1.html");
//        url.setDoc();
//        list = new ArrayList<>();
//        list.add(url);
//
//
//    }
//
//
//}