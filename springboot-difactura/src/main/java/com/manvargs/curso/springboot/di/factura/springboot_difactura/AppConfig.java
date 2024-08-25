package com.manvargs.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.manvargs.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.manvargs.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySources(
    @PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
)
public class AppConfig {

    @Bean
    List<Item> invoiceItems() {
        Product p1 = new Product("Cámara Sony", 800);
        Product p2 = new Product("Bicicleta Bianchi 26", 200);

        List<Item> items = Arrays.asList(new Item(2, p1), new Item(4, p2));
        
        return items;
    }

}
