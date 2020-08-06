package com.codeclan.example.course_booking_system;

import com.codeclan.example.course_booking_system.models.Booking;
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
//	@Test
//	public void canFindCoursesByRating() {
//
//	}
//
//	@Test
//	public void canFindCourseByCustomer() {
//
//	}
//
//	@Test
//	public void canFindCustomersByCourseName() {
//
//	}

}
