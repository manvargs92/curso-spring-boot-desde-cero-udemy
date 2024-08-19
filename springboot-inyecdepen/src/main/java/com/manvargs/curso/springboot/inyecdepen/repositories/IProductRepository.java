package com.manvargs.curso.springboot.inyecdepen.repositories;

import com.manvargs.curso.springboot.inyecdepen.models.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    Product findById(Long id);

}
