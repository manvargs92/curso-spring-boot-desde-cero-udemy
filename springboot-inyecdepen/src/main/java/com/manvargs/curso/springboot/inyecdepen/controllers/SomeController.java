package com.manvargs.curso.springboot.inyecdepen.controllers;

import com.manvargs.curso.springboot.inyecdepen.models.Product;
import com.manvargs.curso.springboot.inyecdepen.services.IProductService;
import com.manvargs.curso.springboot.inyecdepen.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

//    @Autowired
    private IProductService service; // inyección mediante la interfaz (está desacoplado)
//    @Autowired // anotación para inyección de dependencias
//    private ProductServiceImpl service; // sin crear la inatancia, de esta forma para inyección de dependencias (aún está fuertemente acoplado)
//    private ProductServiceImpl service = new ProductServiceImpl(); // objeto concreto que se está acoplando al controlador; se mutarán los datos cada vez que un request acceda al objeto


    public SomeController(IProductService service) { // inyección de dependencias mediante el constructor (no es necesario la naotación @Autowired)
        this.service = service;
    }

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
