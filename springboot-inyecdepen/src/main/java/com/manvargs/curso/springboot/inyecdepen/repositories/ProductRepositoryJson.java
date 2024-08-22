package com.manvargs.curso.springboot.inyecdepen.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manvargs.curso.springboot.inyecdepen.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements IProductRepository {

    private List<Product> list;

//    @Value("classpath:json/product.json")
//    private Resource resource; // leer el JSON inyectándolo con @Value (forma declarativa) (solo fucniona si la clase es un componente Spring)

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json"); // leer un archivo .json (forma programática)
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class)); // convertir el json en un arreglo
//            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class)); // convertir el json en un arreglo
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
