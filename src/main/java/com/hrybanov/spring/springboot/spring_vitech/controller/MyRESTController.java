package com.hrybanov.spring.springboot.spring_vitech.controller;

import com.hrybanov.spring.springboot.spring_vitech.repository.CommentsRepository;
import com.hrybanov.spring.springboot.spring_vitech.entities.Comment;
import com.hrybanov.spring.springboot.spring_vitech.entities.Patient;
import com.hrybanov.spring.springboot.spring_vitech.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://vitechfrontend.herokuapp.com")
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
    public Patient getPatientById(@PathVariable int id) {
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

    @GetMapping("/patients/comments/{id}/{text}/{data}")
    public void setPatientComment(@PathVariable Long id, @PathVariable String text, @PathVariable String data) {

        patientService.setPatientComment(text, data, id);
    }

}
