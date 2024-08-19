package com.manvargs.curso.springboot.inyecdepen.controllers;

import com.manvargs.curso.springboot.inyecdepen.models.Product;
import com.manvargs.curso.springboot.inyecdepen.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductService service = new ProductService(); // objeto concreto que se está acoplando al controlador

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }

}
