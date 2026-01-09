package org.example.week4assignment.controllers;

import org.example.week4assignment.exceptions.CustomerNotFoundException;
import org.example.week4assignment.models.Customer;
import org.example.week4assignment.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void customerNotFound(CustomerNotFoundException e) {
        System.err.println(e.getMessage());
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

}
