//package com.stackroute.plasma.Controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.plasma.controller.UserController;
//import com.stackroute.plasma.model.UserAuth;
//import com.stackroute.plasma.services.UserService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//    @RunWith(SpringRunner.class)
//    @WebMvcTest
//    public class UserControllerTest {
//        @Autowired
//        private MockMvc mockMvc;
//        private UserAuth userAuth;
//
//        @MockBean
//        private UserService userService;
//
//        @InjectMocks
//        private UserController userController;
//
//        private List<UserAuth> list = null;
//
//        @Before
//        public void setUp() {
//            MockitoAnnotations.initMocks(this);
//            mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//            userAuth = new UserAuth();
//            userAuth.setUserId("abcd");
//            userAuth.setPassword("abcd");
//            list = new ArrayList<>();
//            list.add(userAuth);
//        }
//
//        @Test
//        public void saveUsers() throws Exception {
////            System.out.println('userAuth!!!!!!!!!");
//            System.out.println(userAuth.getUserId() + userAuth.getPassword());
//
//            when(userService.saveUsers(any())).thenReturn(userAuth);
//            mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
//                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(userAuth)))
//                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andDo(MockMvcResultHandlers.print());
//        }
//
//        @Test
//        public void getAllUsers() throws Exception {
//
//            when(userService.getAllUsers()).thenReturn(list);
//            mockMvc.perform(MockMvcRequestBuilders.get("/api/userAuth")
//                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(userAuth)))
//                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andDo(MockMvcResultHandlers.print());
//        }
//
//        private static String asJsonString(final Object obj) {
//            try {
//                return new ObjectMapper().writeValueAsString(obj);
//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }
//
//
