package com.manvargs.curso.springboot.webapp.springboot_web.controllers;

import com.manvargs.curso.springboot.webapp.springboot_web.models.User;
import com.manvargs.curso.springboot.webapp.springboot_web.models.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // indica a Spring Boot que es una clase controladora Rest
@RequestMapping("/api/rest") // dar una ruta principal al controlador
public class UserRestController {

    @GetMapping("/details-map") // indica que es una petición GET
    public Map<String, Object> detailsWithMap() {
        User user = new User("Manuel", "Vargas");

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola, Mundo con Spring Boot!!");
        body.put("user", user);
//        body.put("name", "Manuel");
//        body.put("lastName", "Vargas");

        return body; // si trabajamos con servicios Rest, los controladores deben retornar JSON
    }

    @RequestMapping(path="/more-details-map", method=RequestMethod.GET) // anotación cuyos parámetros indican manualmente el path y el método de la petición
    public Map<String, Object> moreDetailsWithMap() {
        Map<String, Object> body = new HashMap<>();

        body.put("example", "Un ejemplo usando @RequestMapping en el método.");

        return body;
    }

    @GetMapping("/detais-dto")
    public UserDto detailsWithDto() {
        User user = new User("Andrés", "Guzmán");
        UserDto userDto = new UserDto();

        userDto.setUser(user);
        userDto.setTitle("Hola, Mundo con Spring Boot");

        return userDto;

    }

    @GetMapping("/list")
    public List<User> usersList() {
        User user = new User("Juan", "Robles");
        User user2 = new User("Luis", "Gonzáles");
        User user3 = new User("José", "Chan");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);

        return users;
    }

}
