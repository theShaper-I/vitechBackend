package com.hrybanov.spring.springboot.spring_vitech.service;

import com.hrybanov.spring.springboot.spring_vitech.entities.Comment;
import com.hrybanov.spring.springboot.spring_vitech.entities.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    void savePatient(Patient patient);

    Patient getPatient(int id);

    void deletePatient(int id);

    List<Comment> getPatientComments(int id);
}
