package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Hospital;
import com.example.exception.HospitalNotFound;
import com.example.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService{
    
    @Autowired
    HospitalRepository hospitalRepository;
    
    @Override
    public Hospital register(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital getHospitalById(Long id) throws HospitalNotFound{
        return hospitalRepository.findById(id).orElseThrow(() -> new HospitalNotFound("hospital not found with id: " + id));
    }

	@Override
	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}
	
	@Override
    public Hospital update(Long hospitalId, Hospital hospitalDetails) throws HospitalNotFound {
        Hospital existingHospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new HospitalNotFound("Hospital not found with id: " + hospitalId));

        existingHospital.setName(hospitalDetails.getName());
        existingHospital.setAddress(hospitalDetails.getAddress());

        return hospitalRepository.save(existingHospital);
    }

	@Override
	public String deleteHospitalById(Long id) {
		hospitalRepository.deleteById(id);
		return "Hospital Deleted";
	}

}
