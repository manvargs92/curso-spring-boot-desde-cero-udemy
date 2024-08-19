/* Esta es la capa de acceso a datos */

package com.manvargs.curso.springboot.inyecdepen.repositories;

import com.manvargs.curso.springboot.inyecdepen.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList( // Arrays.asList() - para crear el array con los valores separados con comas
                new Product(1L, "Memoria Corsair 32GB", 300L),
                new Product(2L, "CPU Intel Core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 180L),
                new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll() {
        return this.data;
    }

    @Override
    public Product findById(Long id) {
//        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(); // si no encuentra el id, .orElseThrow() - regresará una excepción
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null); // si no encuentra el id, .orElse(null) - regresará un null en vez de una execpción
    }

}
