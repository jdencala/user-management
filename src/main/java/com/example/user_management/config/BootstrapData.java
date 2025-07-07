package com.example.user_management.config;

import com.example.user_management.entity.UserApp;
import com.example.user_management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final UserRepository userRepository;

    public BootstrapData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private void createUsers(){
        UserApp u1 = new UserApp();
        u1.setName("Jorge");
        u1.setLastname("Encalada");
        u1.setUsername("jencalada");
        u1.setEmail("jencalada@ups.edu.ec");
        u1.setPassword("12345");

        UserApp u2 = new UserApp();
        u2.setName("Admin");
        u2.setLastname("");
        u2.setUsername("admin");
        u2.setEmail("admin@ups.edu.ec");
        u2.setPassword("admin1");

        userRepository.save(u1);
        userRepository.save(u2);
    }


    @Override
    public void run(String... args) throws Exception {
        createUsers();
        System.out.println("Number of users: " + userRepository.count());
    }
}
