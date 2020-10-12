package com.apulbere.sleuthcustom.web;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
public class HelloController {

    @GetMapping
    String hello() {
        log.info("hi there log");
        return "Hi there!";
    }
}
