//package com.stackroute.plasma.Repository;
//
//import com.stackroute.plasma.model.UserAuth;
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
//    private UserAuth userAuth;
//
//    @Before
//    public void setUp()
//    {
//        userAuth = new UserAuth();
//        userAuth.setUserId("abcd");
//        userAuth.setPassword("Alex");
//        userRepository.save(userAuth);
//    }
//
//    @Test
//  public void saveUserTest()
//    {
//        userRepository.save(userAuth);
//        UserAuth fetchUser = userRepository.findById(userAuth.getUserId()).get();
//       Assert.assertEquals("abcd",fetchUser.getUserId());
//    }
//
//
//    @Test
//    public void testSaveUserFailure(){
//        UserAuth testUser = new UserAuth("fgf","gh","userAuth");
//        userRepository.save(userAuth);
//        UserAuth fetchUser = userRepository.findById(userAuth.getUserId()).get();
//        Assert.assertNotSame(testUser,userAuth);
//    }
//
//
//}
