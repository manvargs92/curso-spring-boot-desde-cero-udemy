package com.manvargs.curso.springboot.di.factura.springboot_difactura;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(
    @PropertySource("classpath:data.properties")
)
public class AppConfig {



}
