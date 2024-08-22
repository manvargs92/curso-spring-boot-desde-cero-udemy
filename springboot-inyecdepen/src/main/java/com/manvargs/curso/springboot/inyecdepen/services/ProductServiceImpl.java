/* La idea es que el service acceda a los datos a través del repository pero además trabaje con esos datos.*/

package com.manvargs.curso.springboot.inyecdepen.services;

import com.manvargs.curso.springboot.inyecdepen.models.Product;
import com.manvargs.curso.springboot.inyecdepen.repositories.IProductRepository;
import com.manvargs.curso.springboot.inyecdepen.repositories.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Component // indica que es un bean
@Service // anotación más especializada que la anotación @Component; indica que es una clase servicio (es una fachada para acceder a lógica de negocio)
public class ProductServiceImpl implements IProductService {

    @Autowired
    private Environment environment; // para usar el valor en values.properties

//    @Autowired
    private IProductRepository repository; // inyección mediante la interfaz (está desacoplado)
//    @Autowired // anotación para inyección de dependencias
//    private ProductRepositoryImpl repository; // sin crear la inatancia, de esta forma para inyección de dependencias (aún está fuertemente acoplado)
//    private ProductRepositoryImpl repository = new ProductRepositoryImpl(); // simulamos los datos del repositorio

    public ProductServiceImpl(@Qualifier("productList") IProductRepository repository) { // @Qualifier - selecciona cual bean inyectar (en nombre debe empezar en minúsculas o su alias de la anotación @Repository("productList") )
//    public ProductServiceImpl(IProductRepository repository) { // inyección de dependencias mediante el constructor (no es necesario la naotación @Autowired)
        this.repository = repository;
    }

    //    @Autowired // inyectar la dependencia mediante el setter
    public void setRepository(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(product -> { // el .map generará una nueva instancia de List<Product> cada vez que se ejecute
            System.out.println(environment.getProperty("config.price.tax", Double.class));
            Double priceWithTax = product.getPrice() * environment.getProperty("config.price.tax", Double.class); // se realiza el cálculo del precio con impuesto
//            Product newProd = new Product(product.getId(), product.getName(), priceWithTax.longValue()); // se crea un nuevo objeto de producto para no mutar los datos

            Product newProd = (Product) product.clone(); // en vez de crear la instancia de Producto, lo clonamos
            newProd.setPrice(priceWithTax.longValue()); // modifica el precio al Producto clonado
            return newProd;

//            product.setPrice(priceWithTax.longValue()); // se modifica el precio, .longValue() - convierte el tipo del valor a Long
//            return product;
        }).collect(Collectors.toList()); // convertimos de el map a list
    }

    @Override
    public  Product findById(Long id) {
        return repository.findById(id);
    }

}
