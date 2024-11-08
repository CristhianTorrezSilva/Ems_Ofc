package com.pa.ems_offc.controller;


import com.pa.ems_offc.dto.HobbyDto;
import com.pa.ems_offc.service.HobbyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/hobbies")

public class HobbyController {
    @Autowired
    private HobbyService hobbyService;

    @PostMapping
    public ResponseEntity<HobbyDto> createHobby(@RequestBody HobbyDto hobbyDto) {
        HobbyDto result = hobbyService.createHobby(hobbyDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    // Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<HobbyDto> getHobbyById(@PathVariable("id") Long hobbyId) {
        HobbyDto hobbyDto = hobbyService.getHobbyById(hobbyId);
        return ResponseEntity.ok(hobbyDto);
    }

    // Build Get All Departments REST API
    @GetMapping
    public ResponseEntity<List<HobbyDto>> getAllHobbies() {
        List<HobbyDto> hobbies = hobbyService.getAllHobbies();
        return ResponseEntity.ok(hobbies);
    }
}


