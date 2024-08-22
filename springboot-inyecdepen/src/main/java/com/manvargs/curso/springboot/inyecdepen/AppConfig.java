package com.manvargs.curso.springboot.inyecdepen;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:values.properties")
public class AppConfig {
}
