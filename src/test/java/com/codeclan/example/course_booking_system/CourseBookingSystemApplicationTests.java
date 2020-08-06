package com.codeclan.example.course_booking_system;

import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.BookingRepository;
import com.codeclan.example.course_booking_system.repositories.CourseRepository;
import com.codeclan.example.course_booking_system.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseBookingSystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}
//
	@Test
	public void canFindBookingsByDate() {
		List<Booking> found = bookingRepository.findByDate("01-01-20");
		assertEquals(2, found.size());
	}
//
	@Test
	public void canFindCoursesByRating() {
		List<Course> found = courseRepository.findByRating(5);
		assertEquals(1, found.size());
	}
//
	@Test
	public void canFindCourseByCustomer() {
		Customer customer = customerRepository.getOne(1L);
		List<Course> found = courseRepository.findByBookingsCustomer(customer);
		assertEquals(3, found.size());
	}
//
	@Test
	public void canFindCustomersByCourseName() {
		List<Customer> found = customerRepository.findByBookingsCourseName("JavaScript");
		assertEquals(2, found.size());
	}

	@Test
	public void canFindCustomersByTownAndCourse() {
		Course course = courseRepository.getOne(1L);
		List<Customer> found = customerRepository.findByTownAndBookingsCourse("York", course);
		assertEquals("Jack", found.get(0).getName());
		assertEquals(2, found.size());
	}

	@Test
	public void canFindCustomersLessThanAgeInTownAndOnCourse() {
		Course course = courseRepository.getOne(1L);
		List<Customer> found = customerRepository.findByAgeLessThanAndTownAndBookingsCourse(40, "Edinburgh", course);
		assertEquals(2, found.size());
		assertEquals("Craig", found.get(0).getName());
		assertEquals("Craig", found.get(1).getName());
	}

}
