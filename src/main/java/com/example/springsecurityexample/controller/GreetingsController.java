package com.example.springsecurityexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {


  @GetMapping("/hello")
  public ResponseEntity<String> hello() {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    System.out.println(authentication.toString());

    return ResponseEntity.ok("hello user with id " + authentication.getName());
  }

  @GetMapping("/bye")
  public ResponseEntity<String> bye() {
    return ResponseEntity.ok("bye");
  }

}