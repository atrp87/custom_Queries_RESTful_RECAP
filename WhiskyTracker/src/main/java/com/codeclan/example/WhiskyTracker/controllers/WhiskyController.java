package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;
//    private Integer x;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="year", required = false) Integer year,
            @RequestParam(name="age", required = false) Integer age,
            @RequestParam(name="distillery", required = false) String distillery

    )
    {

        if (name != null) {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findByWhiskyName(name), HttpStatus.OK);
        }
        if (age != null) {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findByWhiskyYear(age), HttpStatus.OK);
        }
//        Integer x;
        if (xDistillery != null && age != null) {
             return new ResponseEntity<List<Whisky>>(whiskyRepository.findByWhiskyAgeNameDistillery(xDestillery, age), HttpStatus.OK);
        }

        List<Whisky> Whiskies = whiskyRepository.findAll();
            return new ResponseEntity<List<Whisky>>(Whiskies, HttpStatus.OK);
        }
}