package com.example.springsecurityexample.controller;

import com.example.springsecurityexample.config.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final TokenProvider tokenProvider;

  @GetMapping("/login/{userId}")
  public ResponseEntity<String> login(@PathVariable Long userId) {

    return ResponseEntity.ok(tokenProvider.createToken(userId));
  }

}
