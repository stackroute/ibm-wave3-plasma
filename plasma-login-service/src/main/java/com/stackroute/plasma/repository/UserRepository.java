package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User findByUserIdAndPassword(String userId, String password);
}
