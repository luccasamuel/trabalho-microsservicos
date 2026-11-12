package com.hexagon.schoolservice.repository;

import com.hexagon.schoolservice.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entidade, TipoDoId>
public interface SchoolRepository extends JpaRepository<School, Integer> {
}