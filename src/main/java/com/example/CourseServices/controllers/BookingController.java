package com.example.CourseServices.controllers;

import com.example.CourseServices.models.Booking;
import com.example.CourseServices.models.Course;
import com.example.CourseServices.repository.BookingRepository;
import com.sun.xml.bind.v2.util.StackRecorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/date/{date}")
    public ResponseEntity<List<Booking>> getAllBookingsByDate(@PathVariable String date){
        return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
    }


}
