package com.stackroute.plasma.security;

import com.stackroute.plasma.model.UserAuth;
<<<<<<< HEAD

=======
>>>>>>> 370c25dee7b5df118116b0bff1441cc27c018353
import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(UserAuth userAuth);
}



