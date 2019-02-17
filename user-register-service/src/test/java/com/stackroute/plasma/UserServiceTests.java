//package com.stackroute.plasma;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import java.util.Date;
//import java.util.Optional;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.plasma.domain.User;
//import com.stackroute.plasma.exceptions.UpdateException;
//import com.stackroute.plasma.exceptions.UserAlreadyExistException;
//import com.stackroute.plasma.repository.UserRepository;
//import com.stackroute.plasma.service.UserServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//public class UserServiceTests {
//    @Mock
//    private UserRepository userRepository;
//    private User user;
//    @InjectMocks
//    private UserServiceImpl userServiceImpl;
//    Optional<User> options;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        user = new User("1", "madhusekhar", "13-08-1997", "Female", "7659055134", "madhuneelima1@gmail.com", "madhu", "madhu");
//        options = Optional.of(user);
//    }
//
//    @Test
//
//    public void testSaveUser() throws UserAlreadyExistException {
//
//        when(userRepository.save(user)).thenReturn(user);
//        User user5 = userServiceImpl.saveUser(user);
//        assertEquals("Cannot Register User", true, user5);
//        verify(userRepository, times(1)).save(user);
//    }
//
//    @Test(expected = UserAlreadyExistException.class)
//    public void testSaveUserFailure() throws UserAlreadyExistException {
//        when(userRepository.findById(user.getId())).thenReturn(options);
//        when(userRepository.save(user)).thenReturn(user);
//        User user6 = userServiceImpl.saveUser(user);
//    }
//
////    @Test
////    public void getAllUser() throws Exception {
////        when(User.getAllUser()).thenReturn(list);
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/userservice")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////
////    }
//
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
