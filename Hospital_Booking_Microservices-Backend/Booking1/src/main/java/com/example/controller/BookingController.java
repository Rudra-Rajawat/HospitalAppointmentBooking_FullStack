package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Booking;
import com.example.service.BookingService;

import jakarta.validation.Valid;

/**
 * The BookingController class handles HTTP requests for managing bookings.
 * It provides endpoints for registering, retrieving, and deleting bookings.
 */
@RestController
@RequestMapping("/bookings")
public class BookingController {
    
    @Autowired
    BookingService bookingService;
    
    /**
     * Registers a new booking.
     * 
     * @param booking the booking details
     * @return the registered booking
     */
    @PostMapping("/register")
    public ResponseEntity<Booking> register(@Valid @RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.register(booking), HttpStatus.OK);
    }

    /**
     * Retrieves a booking by its ID.
     * 
     * @param id the ID of the booking
     * @return the booking details
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    /**
     * Retrieves all bookings.
     * 
     * @return a list of all bookings
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Booking>> getAll(){
        return ResponseEntity.ok(bookingService.getAll());
    }

    /**
     * Retrieves bookings by patient ID.
     * 
     * @param pId the ID of the patient
     * @return a list of bookings for the specified patient
     */
    @GetMapping("/getByPatientId/{pId}")
    public ResponseEntity<List<Booking>> getByPatientId(@PathVariable("pId") Long pId){
        return ResponseEntity.ok(bookingService.getBookingByPatientId(pId));
    }
    
    @GetMapping("/getByUserId/{uId}")
    public ResponseEntity<List<Booking>> getUserId(@PathVariable("uId") Long uId){
        return ResponseEntity.ok(bookingService.getBookingByUserId(uId));
    }

    /**
     * Deletes bookings by patient ID.
     * 
     * @param pId the ID of the patient
     * @return a confirmation message
     */
    @DeleteMapping("/deleteByPatientId/{pId}")
    public ResponseEntity<String> deleteByPatientId(@PathVariable("pId") Long pId){
        return ResponseEntity.ok(bookingService.deleteBookingBypatientId(pId));
    }
    
    /**
     * Deletes bookings by department ID.
     * 
     * @param dId the ID of the department
     * @return a confirmation message
     */
    @DeleteMapping("/deleteByDepartmentId/{dId}")
    public ResponseEntity<String> deleteBookingDepartmentId(@PathVariable("dId") Long dId){
        return ResponseEntity.ok(bookingService.deleteBookingDepartmentId(dId));
    }
    
    @DeleteMapping("/deleteByBookingId/{bId}")
    public ResponseEntity<String> deleteByBookingId(@PathVariable("bId") Long bId){
        return ResponseEntity.ok(bookingService.deleteByBookingId(bId));
    }
    
    @PutMapping("/updateBooking/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id,@Valid @RequestBody Booking bookingDetails) {
        try {
        	Booking updatedBooking = bookingService.update(id, bookingDetails);
            return ResponseEntity.ok(updatedBooking);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}