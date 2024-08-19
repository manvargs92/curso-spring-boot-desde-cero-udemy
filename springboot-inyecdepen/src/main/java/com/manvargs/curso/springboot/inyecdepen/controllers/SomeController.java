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

    private ProductService service = new ProductService(); // objeto concreto que se está acoplando al controlador; se mutarán los datos cada vez que un request acceda al objeto

    @GetMapping
    public List<Product> list() {
//        ProductService service = new ProductService(); // de esta forma no se mutarán los datos al hacer el request pero no es buena práctica instanciar el objeto dentro del método del request
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
//        ProductService service = new ProductService();
        return service.findById(id);
    }

}
