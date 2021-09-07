package com.hrybanov.spring.springboot.spring_vitech.controller;

import com.hrybanov.spring.springboot.spring_vitech.entities.Comment;
import com.hrybanov.spring.springboot.spring_vitech.entities.Patient;
import com.hrybanov.spring.springboot.spring_vitech.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> showAllPatients() {
        List<Patient> allPatients = patientService.getAllPatients();

        return allPatients;
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable int id) {
        Patient patient = patientService.getPatient(id);

        return patient;
    }

    @PostMapping("/patients")
    public Patient addNewPatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);

        return patient;
    }

    @PutMapping("/patients")
    public Patient updatePatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);

        return patient;
    }

    @DeleteMapping("/patients/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);

        return "Patient with ID = " + id + " was deleted";
    }

    @GetMapping("/comments/{id}")
    public List<Comment> getPatientComments(@PathVariable int id) {

        return patientService.getPatientComments(id);
    }

}
