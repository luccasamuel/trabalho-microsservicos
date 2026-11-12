package com.hexagon.schoolservice.controller;

import com.hexagon.schoolservice.entity.School;
import com.hexagon.schoolservice.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<School> addSchool(@RequestBody School school) {
        return new ResponseEntity<>(schoolService.addSchool(school), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<School>> fetchSchools() {
        return ResponseEntity.ok(schoolService.fetchSchools());
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> fetchSchoolById(@PathVariable("id") Integer id) {
        School school = schoolService.fetchSchoolById(id);
        if (school == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(school);
    }
}