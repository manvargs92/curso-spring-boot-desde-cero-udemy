package com.manvargs.curso.springboot.error.springboot_error;

import com.manvargs.curso.springboot.error.springboot_error.models.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<User> users() {
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Pepe", "González"));
        users.add(new User(2L, "Andrés", "Mena"));
        users.add(new User(3L, "María", "Pérez"));
        users.add(new User(4L, "Josefa", "Ramírez"));
        users.add(new User(5L, "Ale", "Gutierrez"));

        return users;
    }

}
