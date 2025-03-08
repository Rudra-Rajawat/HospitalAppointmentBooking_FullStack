package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.entity.Hospital;
import com.example.exception.HospitalNotFound;


@Service
public interface HospitalService {

    Hospital register(Hospital hospital);
    
    Hospital getHospitalById(Long id) throws HospitalNotFound;
    
    List<Hospital> getAllHospitals();
    
    Hospital update(Long hospitalId, Hospital hospitalDetails) throws HospitalNotFound;
    
    String deleteHospitalById(Long id);
}
