package com.example.bootstrap;

import com.example.domen.Customer;
import com.example.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Customer Data");

        Customer c1 = new Customer();
        c1.setFirstName("Mirshod Allaberganov");
        c1.setNickName("Mirix");
        c1.setPhone("+998973643225");
        c1.setDebt((long) 1000);
        c1.setStatus(false);
        customerRepository.save(c1);


        Customer c2 = new Customer();
        c2.setFirstName("Ali radjabov");
        c2.setNickName("Mirix");
        c2.setPhone("+998973643225");
        c2.setDebt((long) 5300);

        customerRepository.save(c2);


        Customer c3 = new Customer();
        c3.setFirstName("yuban yubanov");
        c3.setNickName("U-eban");
        c3.setPhone("+998973643225");
        c3.setDebt((long) 2500);
        customerRepository.save(c3);

        System.out.println("Customers are saved: " + customerRepository.count());
    }
}
