//package com.stackroute.plasma;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.plasma.controller.UserController;
//import com.stackroute.plasma.domain.User;
//import com.stackroute.plasma.exceptions.UserAlreadyExistException;
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
//import java.util.ArrayList;
//import java.util.List;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class UserControllerTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private User user;
//    @MockBean
//    private UserService userService;
//    @InjectMocks
//    private UserController userController;
//
//    private List<User> list =null;
//
//    @Before
//    public void setUp(){
//
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//        user = new User();
//        user.setId("26");
//        user.setName("Jonny");
//        user.setDateOfBirth("13-08-1997");
//        user.setSetPassword("madhu");
//        user.setConfirmpassword("Jenny");
//        list = new ArrayList();
//
//        list.add(user);
//    }
//
//    @Test
//    public void saveUser() throws UserAlreadyExistException {
//        when(userService.saveUser(any())).thenReturn(user);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/userservice")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//
//
//    }
//    @Test
//    public void saveUserFailure() throws Exception {
//        when(userService.saveUser(any())).thenThrow(UserAlreadyExistException.class);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/userservice")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllUser() throws Exception {
//        when(userService.getAllUser()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/userservice")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
//
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//}