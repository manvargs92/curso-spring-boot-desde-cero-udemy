package com.manvargs.curso.springboot.inyecdepen.repositories;

import com.manvargs.curso.springboot.inyecdepen.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList( // Arrays.asList() - para crear el array con los valores separados con comas
                new Product(1L, "Memoria Corsair 32GB", 300L),
                new Product(2L, "CPU Intel Core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 180L),
                new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    public List<Product> findAll() {
        return this.data;
    }

}
