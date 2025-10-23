package com.example.testSpring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CourierController {

    @GetMapping("/testGet")
    public ResponseEntity<String> testGet(){

        return ResponseEntity
                .ok()
                .body("Test complete");
    }


}
