package com.manvargs.curso.springboot.inyecdepen.repositories;

import com.manvargs.curso.springboot.inyecdepen.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryJPAJDB implements IProductRepository {
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27\"", 600L)); // simulamos una lista con un solo producto
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor Asus 27\"", 600L); // simulamos un producto
    }
}
