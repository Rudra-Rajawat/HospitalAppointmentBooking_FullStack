package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Patient;
import com.example.exception.PatientNotFound;

@Service
public interface PatientService {

    Patient register(Patient patient);

    Patient getPatientById(Long id) throws PatientNotFound;
    
    List<Patient> getAll();
    
    Patient update(Long patientId, Patient patientDetails) throws PatientNotFound;
}