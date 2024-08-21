package com.manvargs.curso.springboot.inyecdepen.repositories;

import com.manvargs.curso.springboot.inyecdepen.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

//@Primary // indica que este es el bean por defecto que implementa IProductRepository, ya que hay 2 beans que lo hacen (el otro es ProductRepositoryImpl)
@Repository("productFoo")
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
