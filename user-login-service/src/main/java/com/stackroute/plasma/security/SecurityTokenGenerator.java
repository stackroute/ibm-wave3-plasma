package com.stackroute.plasma.security;

import com.stackroute.plasma.model.User;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}



