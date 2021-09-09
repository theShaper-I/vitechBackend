package com.hrybanov.spring.springboot.spring_vitech.service;

import com.hrybanov.spring.springboot.spring_vitech.repository.CommentsRepository;
import com.hrybanov.spring.springboot.spring_vitech.repository.PatientRepository;
import com.hrybanov.spring.springboot.spring_vitech.entities.Comment;
import com.hrybanov.spring.springboot.spring_vitech.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

    @Override
    public List<Comment> getPatientComments(int id) {

        return getPatient(id).getCommentsList();
    }

    @Override
    public void setPatientComment(String text, String data, Long id) {

        commentsRepository.setPatientComment(text, data, id);
    }

    @Override
    public Patient getPatient(int id) {
        Patient patient = null;
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isPresent()) {
            patient = patientOptional.get();
        }
        return patient;
    }

    @Override
    public void savePatient(Patient patient) {

        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(int id) {

        patientRepository.deleteById(id);
    }

}
