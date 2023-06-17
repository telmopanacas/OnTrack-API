package com.ontrack.api.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1")
public class MiscellaneousController {

    @GetMapping(path = "/alive")
    public Map<String, String> checkAlive() {
        /*
        Return a json with the current date and time and a messagem saying Alive
         */
        LocalDateTime now = LocalDateTime.now();;
        return Map.of(
                "message", "It's alive! It's alive!",
                "time", now.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
        );

    }
}
