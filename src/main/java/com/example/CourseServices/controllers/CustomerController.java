package com.example.CourseServices.controllers;

import com.example.CourseServices.models.Course;
import com.example.CourseServices.models.Customer;
import com.example.CourseServices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

//    @GetMapping(value = "/customers")
//    public ResponseEntity<List<Customer>> getAllCustomers(){
//        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
//    }
    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomerWithCourseName(@RequestParam(name = "byCourseName", required = false)String name){
        if (name != null) {
            return new ResponseEntity<>(customerRepository.findByBookings_Course_Name(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }

//    @GetMapping(value = "/customers/{course_id}")
//    public ResponseEntity<List<Customer>> getAllCustomersByCourse(@PathVariable Long id){
//        return new ResponseEntity<>(customerRepository.findByBookings_Course_Id(id), HttpStatus.OK);
//    }

}
