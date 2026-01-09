package org.example.week4assignment.controllers;

import org.example.week4assignment.exceptions.CustomerNotFoundException;
import org.example.week4assignment.models.Customer;
import org.example.week4assignment.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
        try {
            return customerService.getCustomer(id);
        } catch (CustomerNotFoundException e) {
            return null;
        }
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

}
