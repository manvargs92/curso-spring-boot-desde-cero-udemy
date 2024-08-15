package com.manvargs.curso.springboot.webapp.springboot_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({ // indica a Spring que se agregarán varios archivos de configuración
//	@PropertySource("classpath:values.properties") // agregar un archivo a Spring de configuraciones externas
	@PropertySource(value="classpath:values.properties", encoding = "UTF-8") // indicar la codificación especial de caracteres
})
public class ProyectoWebConSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoWebConSpringBootApplication.class, args);
	}

}
