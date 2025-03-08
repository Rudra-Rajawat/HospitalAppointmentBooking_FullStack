package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Patient;
import com.example.exception.PatientNotFound;
import com.example.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    
    @Override
    public Patient register(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) throws PatientNotFound{
        return patientRepository.findById(id).orElseThrow(() -> new PatientNotFound("No patient found with id : "+ id));
    }

	@Override
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient update(Long patientId, Patient patientDetails) throws PatientNotFound {
		Patient existingPatient = patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFound("Patient not found with id: " + patientId));
		existingPatient.setName(patientDetails.getName());
		existingPatient.setAge(patientDetails.getAge());
		existingPatient.setGender(patientDetails.getGender());
		return patientRepository.save(existingPatient);
	}
}