package com.stackroute.plasma.controller;//package com.stackroute.plasma.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.plasma.domain.Evaluator;
//import com.stackroute.plasma.service.EvaluatorServiceImpl;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.Mockito.when;
//
//public class EvalControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private Evaluator evaluator;
//    @MockBean
//    private EvaluatorServiceImpl evalService;
////    @InjectMocks
////    private EvalController evalController;
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(evalController).build();
//        evaluator=new Evaluator();
//       //evaluator.timestamp= Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
//        evaluator.domain="java";
//        evaluator.concept="class";
//        evaluator.level="Analysis";
//        evaluator.confidenceScore=161;
//        evaluator.url="https://www.guru99.com/java-oops-class-objects.html";
//        evaluator.setUrl("https://www.guru99.com/java-oops-class-objects.html");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void getScore() throws Exception {
//        when(evaluator.getUrl()).thenReturn(evaluator.getUrl());
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(evaluator.url)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//
//    }
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
