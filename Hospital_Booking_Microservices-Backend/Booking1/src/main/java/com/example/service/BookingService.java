package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Booking;

@Service
public interface BookingService {

	Booking register(Booking booking);
	
	Booking update(Long id,Booking booking);

	Booking getBookingById(Long id);

	List<Booking> getAll();

	List<Booking> getBookingByPatientId(Long patientId);
	
	List<Booking> getBookingByUserId(Long userId);

	String deleteBookingBypatientId(Long patientId);

	String deleteByBookingId(Long bookingId);

	String deleteBookingDepartmentId(Long departmentId);

}