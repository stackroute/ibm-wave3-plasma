//package com.stackroute.searchservice.controller;
//
//import com.stackroute.searchservice.domain.SearchOutput;
//import com.stackroute.searchservice.service.ApiService;
//import org.junit.After;
//import org.junit.Before;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
//import static org.junit.Assert.*;
//
//public class SearchControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private ApiService apiService;
//
//    @InjectMocks
//    @Autowired
//    private SearchController searchController;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
//        SearchOutput searchOutput = new SearchOutput();
//        searchOutput.setDomain("java");
//        searchOutput.setConcept("encapsulation");
//        searchOutput.setUrls(new String[]{"https://www.youtube.com/watch?v=szYzBC89CPE","https://beginnersbook.com/2013/03/oops-in-java-encapsulation-inheritance-polymorphism-abstraction/",
//                "https://www.youtube.com/watch?v=PM47JJe_8xI",
//                "https://dzone.com/articles/java-encapsulation-for-adults",
//                "https://howtodoinjava.com/oops/encapsulation-in-java-and-its-relation-with-abstraction/",
//                "https://www.guru99.com/java-oops-encapsulation.html",
//                "https://programmingstack.com/java-encapsulation.html",
//                "https://quizlet.com/177452001/java-encapsulation-flash-cards/",
//                "https://www.coursehero.com/file/14011464/Java-encapsulation-inheritance-polymorphism/",
//                "https://quizlet.com/332830793/java-encapsulationscope-quiz-flash-cards/"});
//        searchOutput.setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//}

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
//        // nlpModel = new NlpModel();
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