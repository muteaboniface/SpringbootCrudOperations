package com.example.taxcalc.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User boniface = new User(
                    "Boniface",
                    "mutea+test@group12.com",
                    35000f
            );
            User molly = new User(
                    "Molly",
                    "molly@group12.com",
                    45000f
            );
            User snipher = new User(
                    "Snipher",
                    "snipher@group12.com",
                    55000f
            );

            User martin = new User(
                    "Martin",
                    "martin@group12.com",
                    65000f
            );

            User vicky = new User(
                    "Vicky",
                    "vicky@group12.com",
                    75000f
            );

            User tristan = new User(
                    "Tristan",
                    "tristan@group12.com",
                    85000f
            );

            userRepository.saveAll(List.of(boniface,molly,snipher,martin,vicky,tristan));
            // save all takes a list of values.
        };
    }
}
