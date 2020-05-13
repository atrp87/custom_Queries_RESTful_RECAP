package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "region", required = false) String region,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "distillery", required = false) Distillery distillery
    )
    {

        if (year != null) {
            return new ResponseEntity<>(whiskyRepository.findByWhiskyYear(year), HttpStatus.OK);
        }

        if(region != null){
            return new ResponseEntity<>(whiskyRepository.findByWhiskyDistilleryRegion(region), HttpStatus.OK);
        }

        if(distillery != null){ //age &&
            return new ResponseEntity<>(whiskyRepository.findByWhiskyDistilleryRegion(distillery, HttpStatus.OK);
        }

        return new ResponseEntity(whiskyRepository.findAll(), HttpStatus.OK);
    }
}
