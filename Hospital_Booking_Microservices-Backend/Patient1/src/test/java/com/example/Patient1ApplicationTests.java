package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Patient;
import com.example.exception.PatientNotFound;
import com.example.repository.PatientRepository;
import com.example.service.PatientServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class Patient1ApplicationTests {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;
    
    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient();
        patient.setId(1L);
        patient.setName("Jane Doe");
        patient.setAge(25);
        patient.setGender("Female");
    }

    @Test
    void testRegister() {
        when(patientRepository.save(patient)).thenReturn(patient);
        Patient savedPatient = patientService.register(patient);
        assertEquals(patient, savedPatient);
    }

    @Test
    void testGetPatientById() throws PatientNotFound {
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));
        Patient foundPatient = patientService.getPatientById(1L);
        assertEquals(patient, foundPatient);
    }

    @Test
    void testGetPatientByIdNotFound() {
        when(patientRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(PatientNotFound.class, () -> patientService.getPatientById(1L));
    }
}
