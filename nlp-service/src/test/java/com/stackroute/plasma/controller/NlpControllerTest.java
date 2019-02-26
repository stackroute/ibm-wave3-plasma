//package com.stackroute.plasma.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.plasma.model.NlpModel;
//import com.stackroute.plasma.service.NlpService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
////import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import javax.ws.rs.core.MediaType;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class NlpControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private NlpService nlpService;
//    @InjectMocks
//    @Autowired
//    private NlpController nlpController;
//    List<String> expectedQuery;
//    String query;
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//       // nlpModel = new NlpModel();
//        query = "technologies trying";
//        expectedQuery = Arrays.asList("technology","try");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void getToken() throws Exception{
//        when(nlpService.queryConverter(query)).thenReturn(expectedQuery);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/query")
//                .contentType(MediaType.APPLICATION_JSON).content(query))
//                .andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());
//    }
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//}
//
