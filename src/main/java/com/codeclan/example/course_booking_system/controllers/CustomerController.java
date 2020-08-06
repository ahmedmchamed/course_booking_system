package com.codeclan.example.course_booking_system.controllers;

import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomers(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age
    ) {
        if (name != null) {
            return new ResponseEntity(customerRepository.findByName(name), HttpStatus.OK);
        }
        if (town != null) {
            return new ResponseEntity(customerRepository.findByTownContainingIgnoreCase(town), HttpStatus.OK);
        }
        if (age != null) {
            return new ResponseEntity(customerRepository.findByAge(age), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Long id) {
        return new ResponseEntity<Optional<Customer>>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer) {
        Customer updatedCustomer = customerRepository.save(customer);
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }


}
