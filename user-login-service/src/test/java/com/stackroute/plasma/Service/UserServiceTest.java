//package com.stackroute.plasma.Service;
//
//import com.stackroute.plasma.model.UserAuth;
//import com.stackroute.plasma.repository.UserRepository;
//import com.stackroute.plasma.services.UserServiceImpl;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//
//public class UserServiceTest {
//
//
//    UserAuth userAuth;
//
//    @Mock
//    UserRepository userRepository;
//
//    @InjectMocks
//    UserServiceImpl userService;
//    List<UserAuth> list = null;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        userAuth = new UserAuth();
//        userAuth.setUserId("abcd");
//        userAuth.setPassword("abcd");
//        list = new ArrayList<>();
//        list.add(userAuth);
//    }
//
//
//    @Test
//    public void saveUserTest() throws Exception {
//        when(userRepository.save((UserAuth) any())).thenReturn(userAuth);
//        UserAuth savedUser = userService.saveUsers(userAuth);
//        Assert.assertEquals(userAuth, savedUser);
//    }
//    @Test
//    public void getAllUsersTest() {
//        userRepository.save(userAuth);
//        when(userRepository.findAll()).thenReturn(list);
//        List<UserAuth> userList = userService.getAllUsers();
//        Assert.assertEquals(list, userList);
//    }
//
//    @Test
//    public void getAllUsersFailure(){
//
//        UserAuth user1 = new UserAuth();
//        user1.setUserId("adcb");
//        user1.setPassword("123");
//        list = new ArrayList<>();
//        list.add(user1);
//        userRepository.save(user1);
//        //stubbing the mock to return specific data
//        when(userRepository.findAll()).thenReturn(list);
//        List<UserAuth> userlist = userService.getAllUsers();
//        Assert.assertEquals(list,userlist);
//    }
//
//    @Test
//    public void saveUserTestSuccess() throws Exception {
//
//        when(userRepository.save((UserAuth)any())).thenReturn(userAuth);
//        UserAuth savedUser = userService.saveUsers(userAuth);
//        Assert.assertEquals(userAuth,savedUser);
//
//        //verify here verifies that userRepository save method is only called once
//        //verify(userRepository,times(1)).save(userAuth);
//
//    }
//
//    @Test
//    public void saveUserTestfailure() throws Exception {
//
//        when(userRepository.save((UserAuth) any())).thenReturn(null);
//        UserAuth savedUser = userService.saveUsers(userAuth);
//        System.out.println("savedUser:" + savedUser);
//        Assert.assertNotEquals(userAuth, savedUser);
//    }
//}
