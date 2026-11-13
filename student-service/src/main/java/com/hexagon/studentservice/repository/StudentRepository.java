package com.hexagon.studentservice.repository;

import com.hexagon.studentservice.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}