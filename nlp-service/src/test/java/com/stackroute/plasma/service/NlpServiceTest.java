//package com.stackroute.plasma.service;
//
//import com.stackroute.plasma.config.PipelineConfig;
//import edu.stanford.nlp.ling.CoreLabel;
//import edu.stanford.nlp.pipeline.CoreDocument;
//import edu.stanford.nlp.pipeline.StanfordCoreNLP;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.*;
////import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.when;
//
//public class NlpServiceTest {
//
//
//
//    @Mock
//    StanfordCoreNLP stanfordCoreNLP;
//    @Mock
//    CoreDocument coreDocument;
//
//    @Mock
//    CoreLabel coreLabel;
//
//    @Mock
//    PipelineConfig pipelineConfig;
////    @Mock
////    List<CoreLabel> coreLabels;
//    @InjectMocks
//    NlpServiceImpl nlpService=new NlpServiceImpl();
//
//    String query;
//   List<String> expectedQuery ;
//
//    @Before
//    public void setUp() throws Exception {
//
//        MockitoAnnotations.initMocks(this);
//        //coreLabels = new ArrayList<>();
//        query = "technologies trying";
//         expectedQuery = Arrays.asList("technology","try");
//        //expectedQuery.add("technologies");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void testQueryConverter() {
//       // nlpService.queryConverter(query);
//        System.out.println(query);
//        System.out.println(expectedQuery);
//       // when(nlpService.queryConverter(query)).thenReturn(expectedQuery);
//       // Assert.assertEquals(expectedQuery, nlpService.queryConverter(query));
//
//    }
//}