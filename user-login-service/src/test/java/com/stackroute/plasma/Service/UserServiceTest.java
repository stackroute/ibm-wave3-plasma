//package com.stackroute.plasma.Service;
//
//import com.stackroute.plasma.model.User;
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
//    User user;
//
//    @Mock
//    UserRepository userRepository;
//
//    @InjectMocks
//    UserServiceImpl userService;
//    List<User> list = null;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        user = new User();
//        user.setUserId("abcd");
//        user.setPassword("abcd");
//        list = new ArrayList<>();
//        list.add(user);
//    }
//
//
//    @Test
//    public void saveUserTest() throws Exception {
//        when(userRepository.save((User) any())).thenReturn(user);
//        User savedUser = userService.saveUsers(user);
//        Assert.assertEquals(user, savedUser);
//    }
//    @Test
//    public void getAllUsersTest() {
//        userRepository.save(user);
//        when(userRepository.findAll()).thenReturn(list);
//        List<User> userList = userService.getAllUsers();
//        Assert.assertEquals(list, userList);
//    }
//
//    @Test
//    public void getAllUsersFailure(){
//
//        User user1 = new User();
//        user1.setUserId("adcb");
//        user1.setPassword("123");
//        list = new ArrayList<>();
//        list.add(user1);
//        userRepository.save(user1);
//        //stubbing the mock to return specific data
//        when(userRepository.findAll()).thenReturn(list);
//        List<User> userlist = userService.getAllUsers();
//        Assert.assertEquals(list,userlist);
//    }
//
//    @Test
//    public void saveUserTestSuccess() throws Exception {
//
//        when(userRepository.save((User)any())).thenReturn(user);
//        User savedUser = userService.saveUsers(user);
//        Assert.assertEquals(user,savedUser);
//
//        //verify here verifies that userRepository save method is only called once
//        //verify(userRepository,times(1)).save(user);
//
//    }
//
//    @Test
//    public void saveUserTestfailure() throws Exception {
//
//        when(userRepository.save((User) any())).thenReturn(null);
//        User savedUser = userService.saveUsers(user);
//        System.out.println("savedUser:" + savedUser);
//        Assert.assertNotEquals(user, savedUser);
//    }
//}
