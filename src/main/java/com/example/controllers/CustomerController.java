package com.example.controllers;

import com.example.domen.Customer;
import com.example.repositories.CustomerRepository;
import com.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/hello")
    public String welcome() {
        return "login";
    }



    @GetMapping()
    List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/show")
    public String show(Map<String, Object> model) {
        Iterable<Customer> customer = customerRepository.findAll();

        model.put("customer", customer);

        return "login";
    }

    @PostMapping("/hello")
    public String addDebt(@RequestParam String custName, @RequestParam String custNickname, @RequestParam Long custDebt, @RequestParam String custPhone, Map<String, Object> model) {
        Customer customer = new Customer(custName, custNickname, custDebt, custPhone);
        customerRepository.save(customer);

        Iterable<Customer> users = customerRepository.findAll();

        model.put("users", users);
        return "login";
    }

    @GetMapping("/error")
    public String error(Map<String, Object> model) {
        return "error";
    }
}
