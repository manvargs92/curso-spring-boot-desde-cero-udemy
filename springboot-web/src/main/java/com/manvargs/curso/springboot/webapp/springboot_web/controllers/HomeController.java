package com.manvargs.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /* Redireccionamiento
    * redirect: realiza una redirección hacia otra ruta indicada; los PARÁMETROS de la petición se PIERDEN
    * fordward: realiza una seguimiento hacia otra ruta indicada; la petición se mantiene por lo cual no se pierden los
    *           parámetros del request ya que no cambia la url
    * */
    @GetMapping({"", "/", "/home"})
    public String home() {
        return "forward:/mvc/list";
//        return "redirect:/mvc/list";
    }

}
