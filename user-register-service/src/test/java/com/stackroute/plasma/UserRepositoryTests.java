//package com.stackroute.plasma;
//import com.stackroute.plasma.domain.User;
//import com.stackroute.plasma.repository.UserRepository;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//        import java.util.List;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class UserRepositoryTests{
//
//    @Autowired
//    UserRepository userRepository;
//    User user;
//
//    @Before
//    public void setUp()
//    {
//        user = new User();
//        user.setName("John");
//        user.setId("101");
//        user.setName("Jenny");
//
//    }
//
//    @After
//    public void tearDown(){
//
//        userRepository.deleteAll();
//    }
//
//
//    @Test
//    public void testSaveUser(){
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getId()).get();
//        Assert.assertEquals(101,fetchUser.getId());
//
//    }
//
//    @Test
//    public void testSaveUserFailure(){
//        User testUser = new User("1","john","34","F","76589055124","Harry123","201","201");
//        userRepository.save(user);
//        User fetchUser = userRepository.findById(user.getId()).get();
//        Assert.assertNotSame(testUser,user);
//    }
//
//    @Test
//    public void testGetAllUser(){
//        User u = new User("1","madhu","13081997","f","7659055124","madhuneelima1@gmail.com","madhu","madhu");
//        userRepository.save(u);
//        List<User> list = userRepository.findAll();
//        Assert.assertEquals("Johny",list.get(0).getName());
//
//
//
//
//    }
//
//
//}