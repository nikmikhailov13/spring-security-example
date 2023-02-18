package com.example.springsecurityexample.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

  private Map<String, String> userMap = new HashMap<>();


  public void createUser(String email, String password) {
    userMap.put(email, password);
  }

  public String getPassword(String email) {
    return userMap.get(email);
  }
}
