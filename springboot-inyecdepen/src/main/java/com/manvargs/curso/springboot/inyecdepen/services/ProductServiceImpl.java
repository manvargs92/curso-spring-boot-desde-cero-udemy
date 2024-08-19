/* La idea es que el service acceda a los datos a través del repository pero además trabaje con esos datos.*/

package com.manvargs.curso.springboot.inyecdepen.services;

import com.manvargs.curso.springboot.inyecdepen.models.Product;
import com.manvargs.curso.springboot.inyecdepen.repositories.ProductRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements IProductService {

    private ProductRepositoryImpl repository = new ProductRepositoryImpl(); // simulamos los datos del repositorio

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(product -> { // el .map generará una nueva instancia de List<Product> cada vez que se ejecute
            Double priceWithTax = product.getPrice() * 1.25; // se realiza el cálculo del precio con impuesto
            Product newProd = (Product) product.clone(); // en vez de crear la instancia de Producto, lo clonamos
            newProd.setPrice(priceWithTax.longValue()); // modifica el precio al Producto clonado
//            Product newProd = new Product(product.getId(), product.getName(), priceWithTax.longValue()); // se crea un nuevo objeto de producto para no mutar los datos
//            product.setPrice(priceWithTax.longValue()); // se modifica el precio, .longValue() - convierte el tipo del valor a Long

//            return product;
            return newProd;
        }).collect(Collectors.toList()); // convertimos de el map a list
    }

    @Override
    public  Product findById(Long id) {
        return repository.findById(id);
    }

}
