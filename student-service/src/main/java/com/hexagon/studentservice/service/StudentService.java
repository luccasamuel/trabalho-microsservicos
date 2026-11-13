package com.hexagon.studentservice.service;

import com.hexagon.studentservice.dto.SchoolDTO;
import com.hexagon.studentservice.dto.StudentResponse;
import com.hexagon.studentservice.model.Student;
import com.hexagon.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;
    private final String schoolServiceUrl;

    public StudentService(StudentRepository studentRepository,
                          RestTemplate restTemplate,
                          @Value("${school-service.url}") String schoolServiceUrl) {
        this.studentRepository = studentRepository;
        this.restTemplate = restTemplate;
        this.schoolServiceUrl = schoolServiceUrl;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    public StudentResponse fetchStudentById(String id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return null;
        }

        SchoolDTO school = null;
        if (student.getSchoolId() != null) {
            try {
                school = restTemplate.getForObject(
                        schoolServiceUrl + "/school/{id}",
                        SchoolDTO.class,
                        student.getSchoolId());
            } catch (RestClientException e) {
                school = null;
            }
        }

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getGender(),
                school);
    }
}