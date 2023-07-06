package com.example.CourseServices.repository;

import com.example.CourseServices.models.Course;
import com.example.CourseServices.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    List<Customer> findByBookings_Course_Id(Long id);

    List<Customer> findByBookings_Course_Name(String name);



}
