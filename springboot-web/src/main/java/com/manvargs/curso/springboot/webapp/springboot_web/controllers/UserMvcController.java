package com.manvargs.curso.springboot.webapp.springboot_web.controllers;

/* Un controlador es una clase común que maneja métodos del request conocidos como "Métodos Handler" */

import com.manvargs.curso.springboot.webapp.springboot_web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller // indica a Spring que es una clase controladora
public class UserMvcController {

    @GetMapping("/mvc/details") // indica que es una petición GET
//    public String details(Model model) { // Model se utiliza para pasarle datos a la vista
    public String details(Model model) { // Model se utiliza para pasarle datos a la vista
        User user = new User("Manuel", "Vargas", null);

        model.addAttribute("title", "Hola, Mundo con Spring Boot!!");
        model.addAttribute("user", user);
//        model.addAttribute("name", "Manuel");
//        model.addAttribute("lastName", "Vargas");

        return "details"; // si trabajamos con el modelo MVC los controladores deben retornar vistas o plantillas HTML del lado del servidor
    }

    @GetMapping("/mvc/list")
    public String list(ModelMap modelMap) { // ModelMap es una lista de Model
//        List<User> users = Arrays.asList( // Arrays.asList() forma corta en vez de usar new ArrayList<>() y llenar la lista con .add
//                new User("Lalo", "Gonzáles", "lalo@correo"),
//                new User("Juanita", "Roa", "juanita@correo"),
//                new User("Andrés", "Doe", "andres@correo"),
//                new User("María", "Hernández", "maria@correo")
//        );

//        modelMap.addAttribute("users", users);
        modelMap.addAttribute("title", "Listado de usuarios");

        return "list";
    }

    @ModelAttribute("users") // indica un modelo para poder ser reutilizado en varios lugares
    public List<User> usersModel() {
        List<User> users = Arrays.asList( // Arrays.asList() forma corta en vez de usar new ArrayList<>() y llenar la lista con .add
                new User("Lalo", "Gonzáles", "lalo@correo"),
                new User("Juanita", "Roa", "juanita@correo"),
                new User("Andrés", "Doe", "andres@correo"),
                new User("María", "Hernández", "maria@correo")
        );

        return users;
    }

}
