package com.example.CourseServices.others;

import com.example.CourseServices.models.Booking;
import com.example.CourseServices.models.Course;
import com.example.CourseServices.models.Customer;
import com.example.CourseServices.repository.BookingRepository;
import com.example.CourseServices.repository.CourseRepository;
import com.example.CourseServices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Course dataAnalysis = new Course("Data Analysis", "Edinburgh", 4);
        courseRepository.save(dataAnalysis);
        Course softwareDevelopment = new Course("Software Development", "Edinburgh", 5);
        courseRepository.save(softwareDevelopment);
        Course userExperience = new Course("User Experience", "Glasgow", 2);
        courseRepository.save(userExperience);
        Customer juan = new Customer("Juan", "Edinburgh", 25);
        customerRepository.save(juan);
        Customer andrew = new Customer("Andrew", "Bangkok", 26);
        customerRepository.save(andrew);
        Customer caroline = new Customer("Caroline", "Edinburgh", 31);
        customerRepository.save(caroline);
        Booking bookingDA = new Booking("27-12-08", dataAnalysis, juan);
        bookingRepository.save(bookingDA);
        Booking bookingSD = new Booking("27-12-08", softwareDevelopment, andrew);
        bookingRepository.save(bookingSD);
        Booking bookingUX = new Booking("27-12-10", userExperience, caroline);
        bookingRepository.save(bookingUX);

    }
}
