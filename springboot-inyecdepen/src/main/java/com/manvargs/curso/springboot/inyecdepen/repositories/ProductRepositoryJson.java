package com.manvargs.curso.springboot.inyecdepen.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manvargs.curso.springboot.inyecdepen.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements IProductRepository {

    private List<Product> list;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json"); // leer un archivo .json
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class)); // convertir el json en un arreglo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
    }
}
