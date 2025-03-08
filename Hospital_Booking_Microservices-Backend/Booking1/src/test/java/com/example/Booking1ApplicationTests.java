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

import com.example.entity.Booking;
import com.example.repository.BookingRepository;
import com.example.service.BookingServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class Booking1ApplicationTests {

	@Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private Booking booking;

    @BeforeEach
    void setUp() {
        booking = new Booking();
        booking.setId(1L);
        booking.setPatientId(101L);
        booking.setPatientName("John Doe");
        booking.setPatientAge(30);
        booking.setPatientGender("Male");
        booking.setHospitalId(201L);
        booking.setHospitalName("City Hospital");
        booking.setHospitalAddress("123 Main St");
        booking.setDepartmentId(301L);
        booking.setDepartmentName("Cardiology");
        booking.setStatus("Confirmed");
    }

    @Test
    void testRegister() {
        when(bookingRepository.save(booking)).thenReturn(booking);
        Booking savedBooking = bookingService.register(booking);
        assertEquals(booking, savedBooking);
    }

    @Test
    void testGetBookingById() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        Booking foundBooking = bookingService.getBookingById(1L);
        assertEquals(booking, foundBooking);
    }

    @Test
    void testGetBookingByIdNotFound() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> bookingService.getBookingById(1L));
    }

    @Test
    void testGetAll() {
        List<Booking> bookings = Arrays.asList(booking);
        when(bookingRepository.findAll()).thenReturn(bookings);
        List<Booking> foundBookings = bookingService.getAll();
        assertEquals(bookings, foundBookings);
    }

    @Test
    void testGetBookingByPatientId() {
        when(bookingRepository.findById(101L)).thenReturn(Optional.of(booking));
        List<Booking> foundBooking = bookingService.getBookingByPatientId(101L);
        assertEquals(booking, foundBooking);
    }
}
