package com.manvargs.curso.springboot.inyecdepen;

import com.manvargs.curso.springboot.inyecdepen.repositories.IProductRepository;
import com.manvargs.curso.springboot.inyecdepen.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:values.properties")
public class AppConfig {

    @Bean // registrar la clase como componente de Spring
//    @Primary
    public IProductRepository productRepository() {
        return new ProductRepositoryJson();
    }

}
