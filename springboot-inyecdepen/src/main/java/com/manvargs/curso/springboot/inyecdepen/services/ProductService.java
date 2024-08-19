/* La idea es que el service acceda a los datos a través del repository pero además trabaje con esos datos.*/

package com.manvargs.curso.springboot.inyecdepen.services;

import com.manvargs.curso.springboot.inyecdepen.models.Product;
import com.manvargs.curso.springboot.inyecdepen.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private ProductRepository repository = new ProductRepository(); // simulamos los datos del repositorio

    public List<Product> findAll() {
        return repository.findAll().stream().map(product -> { // el .map generará una nueva instancia de List<Product> cada vez que se ejecute
            Double priceWithTax = product.getPrice() * 1.25; // se realiza el cálculo del precio con impuesto
            Product newProd = new Product(product.getId(), product.getName(), priceWithTax.longValue()); // se crea un nuevo objeto de producto para no mutar los datos
//            product.setPrice(priceWithTax.longValue()); // se modifica el precio, .longValue() - convierte el tipo del valor a Long

//            return product;
            return newProd;
        }).collect(Collectors.toList()); // convertimos de el map a list
    }

    public  Product findById(Long id) {
        return repository.findById(id);
    }

}
