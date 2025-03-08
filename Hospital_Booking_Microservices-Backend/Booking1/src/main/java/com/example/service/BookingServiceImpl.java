package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Booking;
import com.example.repository.BookingRepository;

/**
 * The BookingServiceImpl class provides the implementation of the BookingService interface.
 * It handles the business logic for managing bookings.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    /**
     * Registers a new booking.
     * 
     * @param booking the booking details
     * @return the registered booking
     */
    @Override
    public Booking register(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * Retrieves a booking by its ID.
     * 
     * @param id the ID of the booking
     * @return the booking details
     * @throws RuntimeException if no booking is found with the given ID
     */
    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("No booking found"));
    }

    /**
     * Retrieves all bookings.
     * 
     * @return a list of all bookings
     */
    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    /**
     * Retrieves bookings by patient ID.
     * 
     * @param patientId the ID of the patient
     * @return a list of bookings for the specified patient
     */
    @Override
    public List<Booking> getBookingByPatientId(Long patientId) {
        return bookingRepository.findByPatientId(patientId);
    }

    /**
     * Deletes bookings by patient ID.
     * 
     * @param patientId the ID of the patient
     * @return a confirmation message
     */
    @Override
    public List<Booking> getBookingByUserId(Long userId) {
        return bookingRepository.findByPatientId(userId);
    }
    
    @Override
    public String deleteBookingBypatientId(Long patientId) {
        bookingRepository.deleteById(patientId);
        return "Booking Deleted";
    }

    /**
     * Deletes bookings by department ID.
     * 
     * @param departmentId the ID of the department
     * @return a confirmation message
     */
    @Override
    public String deleteBookingDepartmentId(Long departmentId) {
        bookingRepository.deleteById(departmentId);
        return "Booking Deleted";
    }

	@Override
	public String deleteByBookingId(Long bookingId) {
		bookingRepository.deleteById(bookingId);
		return "Booking deleted";
	}

	@Override
	public Booking update(Long id, Booking booking) {
		Booking exsitingBooking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("No booking found"));
		exsitingBooking.setPatientId(booking.getPatientId());
		exsitingBooking.setPatientId(booking.getUserId());
		exsitingBooking.setPatientName(booking.getPatientName());
		exsitingBooking.setPatientAge(booking.getPatientAge());
		exsitingBooking.setPatientGender(booking.getPatientGender());
		exsitingBooking.setHospitalId(booking.getHospitalId());
//		exsitingBooking.setHospitalName(booking.getHospitalName());
//		exsitingBooking.setHospitalAddress(booking.getHospitalAddress());
		exsitingBooking.setDepartmentId(booking.getDepartmentId());
//		exsitingBooking.setDepartmentName(booking.getDepartmentName());
		exsitingBooking.setStatus(booking.getStatus());
		return bookingRepository.save(exsitingBooking);
	}
}