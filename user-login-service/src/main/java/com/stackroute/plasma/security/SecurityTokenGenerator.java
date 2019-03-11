package com.stackroute.plasma.security;

import com.stackroute.plasma.model.UserAuth;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(UserAuth userAuth);
}



