package org.example.week4assignment.services;

import org.example.week4assignment.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {
    private final Map<Integer, Customer> customers;
    public CustomerService() {
        this.customers = new HashMap<>();
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomer(int id) {
        return customers.get(id);
    }

    public Customer updateCustomer(int id, Customer customer) {
        if (!customers.containsKey(id)) {
            return null;
        }
        customers.put(id, customer);
        return customer;
    }

    public boolean deleteCustomer(int id){
        return customers.remove(id) != null;
    }

}
