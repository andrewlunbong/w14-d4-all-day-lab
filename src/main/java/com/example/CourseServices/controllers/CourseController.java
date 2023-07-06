package com.example.CourseServices.controllers;

import com.example.CourseServices.models.Course;
import com.example.CourseServices.models.Customer;
import com.example.CourseServices.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/rating/{rating}")
    public ResponseEntity<List<Course>> getAllCoursesByRating(@PathVariable int rating){
        return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/customer")
    public ResponseEntity<List<Course>> getAllCustomersByCourse(@RequestParam(name = "byCustomerName") String name){
        return new ResponseEntity<>(courseRepository.findByBookings_Customer_Name(name), HttpStatus.OK);
    }
}
