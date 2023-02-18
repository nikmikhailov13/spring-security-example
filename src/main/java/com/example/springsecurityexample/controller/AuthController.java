package com.example.springsecurityexample.controller;

import com.example.springsecurityexample.config.TokenProvider;
import com.example.springsecurityexample.controller.dto.UserCredentialsDto;
import com.example.springsecurityexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final TokenProvider tokenProvider;
  private final UserService userService;


  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody UserCredentialsDto userCredentialsDto) {

    userService.createUser(userCredentialsDto.email(), userCredentialsDto.password());

    return ResponseEntity.ok("User " + userCredentialsDto.email() + " was created!");
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody UserCredentialsDto userCredentialsDto) {

    if (userService.validateCredentials(userCredentialsDto.email(),
        userCredentialsDto.password())) {
      return ResponseEntity.ok(tokenProvider.createToken(userCredentialsDto.email()));
    }

    return ResponseEntity.status(401).body("Invalid credentials");
  }

}
