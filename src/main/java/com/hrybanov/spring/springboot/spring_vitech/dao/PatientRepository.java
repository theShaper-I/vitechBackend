package com.hrybanov.spring.springboot.spring_vitech.dao;

import com.hrybanov.spring.springboot.spring_vitech.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
