package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	List<Booking> findByPatientId(Long patientId);
	
	List<Booking> findByUserId(Long userId);
	
}
