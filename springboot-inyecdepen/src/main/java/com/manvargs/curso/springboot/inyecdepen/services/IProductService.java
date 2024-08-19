package com.manvargs.curso.springboot.inyecdepen.services;

import com.manvargs.curso.springboot.inyecdepen.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

}
