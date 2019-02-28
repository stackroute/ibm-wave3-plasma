//package com.stackroute.plasma.Repository;
//
//import com.stackroute.plasma.model.User;
//import com.stackroute.plasma.repository.UserRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class UserRepositoryTest {
//    @Autowired
//    private UserRepository userRepository;
//    private User user;
//
//    @Before
//    public void setUp()
//    {
//        user = new User();
//        user.setUserId("abcd");
//        user.setPassword("Alex");
//        userRepository.save(user);
//    }
//
//    @Test
//  public void saveUserTest()
//    {
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getUserId()).get();
//       Assert.assertEquals("abcd",fetchUser.getUserId());
//    }
//
//
//    @Test
//    public void testSaveUserFailure(){
//        User testUser = new User("fgf","gh","user");
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getUserId()).get();
//        Assert.assertNotSame(testUser,user);
//    }
//
//
//}
