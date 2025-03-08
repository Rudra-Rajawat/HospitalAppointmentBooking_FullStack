package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Hospital;
import com.example.exception.HospitalNotFound;
import com.example.repository.HospitalRepository;
import com.example.service.HospitalServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class Hospital1ApplicationTests {

	@Mock
    private HospitalRepository hospitalRepository;

    @InjectMocks
    private HospitalServiceImpl hospitalService;

    private Hospital hospital;

    @BeforeEach
    void setUp() {
        hospital = new Hospital();
        hospital.setId(1L);
        hospital.setName("City Hospital");
        hospital.setAddress("123 Main St");
    }

    @Test
    void testRegister() {
        when(hospitalRepository.save(hospital)).thenReturn(hospital);
        Hospital savedHospital = hospitalService.register(hospital);
        assertEquals(hospital, savedHospital);
    }

    @Test
    void testGetHospitalById() throws HospitalNotFound {
        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(hospital));
        Hospital foundHospital = hospitalService.getHospitalById(1L);
        assertEquals(hospital, foundHospital);
    }

    @Test
    void testGetHospitalByIdNotFound() {
        when(hospitalRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(HospitalNotFound.class, () -> hospitalService.getHospitalById(1L));
    }

    @Test
    void testGetAllHospitals() {
        List<Hospital> hospitals = Arrays.asList(hospital);
        when(hospitalRepository.findAll()).thenReturn(hospitals);
        List<Hospital> foundHospitals = hospitalService.getAllHospitals();
        assertEquals(hospitals, foundHospitals);
    }

}
