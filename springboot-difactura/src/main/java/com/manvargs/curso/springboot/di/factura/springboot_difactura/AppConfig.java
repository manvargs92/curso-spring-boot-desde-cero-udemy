package com.manvargs.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.manvargs.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.manvargs.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySources(
    @PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
)
public class AppConfig {

    @Bean("default")
    // @Primary
    List<Item> invoiceItems() {
        Product p1 = new Product("Cámara Sony", 800);
        Product p2 = new Product("Bicicleta Bianchi 26", 200);

        List<Item> items = Arrays.asList(new Item(2, p1), new Item(4, p2));
        
        return items;
    }

    @Bean
    // @Primary
    List<Item> invoiceOfficeItems() {
        Product p1 = new Product("Monitor Asus 24\"", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Impresora HP", 800);
        Product p4 = new Product("Escritorio Oficina", 900);

        List<Item> items = Arrays.asList(
            new Item(4, p1),
            new Item(6, p2),
            new Item(1, p3),
            new Item(4, p4)
        );
        
        return items;
    }

}
