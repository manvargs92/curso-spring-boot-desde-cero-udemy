/* Esta es la capa de acceso a datos */

package com.manvargs.curso.springboot.inyecdepen.repositories;

import com.manvargs.curso.springboot.inyecdepen.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;

//@Component // indica que es un bean
//@RequestScope // alcance del request; cambia el contexto, la plicación dejará de ser singleton (un solo estado compartido por todos los usuarios) y empezará a ser por cada usuario (la data ya no se almacena en memoria de la aplicación)
//@SessionScope // similar a @RequestScope, pero será en el contexto de la sesión
@Primary // indica que este es el bean por defecto que implementa IProductRepository, ya que hay 2 beans que lo hacen (el otro es ProductRepositoryJPAJDB)
@Repository("productList") // anotación más especializada que la anotación @Component; indica que es una clase repositorio
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
