package com.stackroute.plasma.repository;

import com.stackroute.plasma.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserAuth,String> {
    public UserAuth findByUserIdAndPassword(String userId, String password);
}
