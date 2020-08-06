package com.codeclan.example.course_booking_system.repositories;

import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByName(String name);

    List<Customer> findByTownContainingIgnoreCase(String town);

    List<Customer> findByAge(int age);

    List<Customer> findByBookingsCourseName(String name);

    List<Customer> findByTownAndBookingsCourse(String town, Course course);

    List<Customer> findByAgeLessThanAndTownAndBookingsCourse(int age, String town, Course course);

}
