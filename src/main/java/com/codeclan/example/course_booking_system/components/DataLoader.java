package com.codeclan.example.course_booking_system.components;

import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.BookingRepository;
import com.codeclan.example.course_booking_system.repositories.CourseRepository;
import com.codeclan.example.course_booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {
        Customer jack = new Customer("Jack", "York", 75);
        customerRepository.save(jack);

        Customer craig = new Customer("Craig", "Edinburgh", 13);
        customerRepository.save(craig);

        Customer adam = new Customer("Adam", "Edinburgh", 34);
        customerRepository.save(adam);

        Course python = new Course("Python", "Glasgow", 4);
        courseRepository.save(python);

        Course javaScript = new Course("JavaScript", "Inverness", 5);
        courseRepository.save(javaScript);

        Course java = new Course("Java", "Edinburgh",3);
        courseRepository.save(java);

        Booking booking1 = new Booking("01-01-20", python, jack);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("01-01-20", python, craig);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("05-05-20", java, adam);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("05-05-20", java, craig);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("10-10-20", javaScript, jack);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("10-10-20", javaScript, adam);
        bookingRepository.save(booking6);

        Booking booking7 = new Booking("12-12-20", python, craig);
        bookingRepository.save(booking7);

        Booking booking8 = new Booking("12-12-20", python, jack);
        bookingRepository.save(booking8);

//        python.addBooking(booking1);
//        python.addBooking(booking2);
//        python.addBooking(booking7);
//        python.addBooking(booking8);
        python.addBooking(booking1);
        python.addBooking(booking2);
        python.addBooking(booking2);
        courseRepository.save(python);

        java.addBooking(booking3);
        java.addBooking(booking4);
        courseRepository.save(java);

        javaScript.addBooking(booking5);
        javaScript.addBooking(booking6);
        courseRepository.save(javaScript);

    }
}
