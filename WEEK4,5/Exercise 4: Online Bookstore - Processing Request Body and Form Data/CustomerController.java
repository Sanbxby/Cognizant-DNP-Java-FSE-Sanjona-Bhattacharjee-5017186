package com.example.bookstore.controller;

import com.example.bookstore.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        customers.add(newCustomer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    // POST endpoint to process form data for customer registration
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestParam Long id,
                                                     @RequestParam String name,
                                                     @RequestParam String email) {
        Customer newCustomer = new Customer(id, name, email);
        customers.add(newCustomer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }
}
