//package com.stackroute.plasma.controller;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.plasma.domain.Url;
//import com.stackroute.plasma.service.DocumentService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import javax.ws.rs.core.MediaType;
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(SpringRunner.class)
//public class DocumentControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    private Url url;
//    private List<Url> list = null;
//    @MockBean
//    private DocumentService documentService;
//
//    @InjectMocks
//    private DocumentController documentController;
//
//    @Test
//    public void getContent() throws Exception {
//        when(documentService.getDocument()).thenReturn(url);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/doc")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(url)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//}