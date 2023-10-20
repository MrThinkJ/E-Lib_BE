package com.dtu.elibrary.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<String> TestGetRequest(){
        return ResponseEntity.ok("Get successfully");
    }

    @PostMapping("/test")
    public ResponseEntity<String> TestPostRequest(){
        return new ResponseEntity<>("Post successfully", HttpStatus.CREATED);
    }

    @GetMapping("/admin/test")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> TestAdmin(){
        return ResponseEntity.ok("Admin test successfully");
    }
}
