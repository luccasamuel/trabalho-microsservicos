package com.hexagon.schoolservice.service;

import com.hexagon.schoolservice.entity.School;
import com.hexagon.schoolservice.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> fetchSchools() {
        return schoolRepository.findAll();
    }

    public School fetchSchoolById(Integer id) {
        return schoolRepository.findById(id).orElse(null);
    }
}