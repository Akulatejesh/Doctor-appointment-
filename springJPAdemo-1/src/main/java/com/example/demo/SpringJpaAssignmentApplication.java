package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.entities.Account;
import com.example.demo.repository.AccountRepository;

@SpringBootApplication
public class SpringJpaAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaAssignmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AccountRepository repository) {
        return (args) -> {
            try {
                repository.save(new Account("987654321", 5000.0));   
                repository.save(new Account("123456789", 8000.0));  
                repository.save(new Account("555555555", 12000.0));

                repository.findAll().forEach(System.out::println);

                Account acc1 = repository.findById(1).orElseThrow(() -> new RuntimeException("Account not found"));
                acc1.withdraw(1000.0);
                repository.save(acc1);
                System.out.println("Updated Account 1: " + acc1);

                Account acc2 = repository.findById(2).orElseThrow(() -> new RuntimeException("Account not found"));
                acc2.deposit(2500.0);
                repository.save(acc2);
                System.out.println("Updated Account 2: " + acc2);

                Account acc3 = repository.findById(3).orElseThrow(() -> new RuntimeException("Account not found"));
                Account acc4 = repository.findById(1).orElseThrow(() -> new RuntimeException("Account not found"));
                acc3.transfer(acc4, 3000.0);
                repository.save(acc3);
                repository.save(acc4);
                System.out.println("Updated Account 3: " + acc3);
                System.out.println("Updated Account 1: " + acc4);

            } catch (Exception e) {
                
                e.printStackTrace();
            }
        };
    }
}
