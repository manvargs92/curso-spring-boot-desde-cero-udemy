package com.manvargs.curso.springboot.app.interceptors.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod controller = ((HandlerMethod)handler); // casteo al method
        logger.info("LoadingTimeInterceptor: preHandle() entrando ...." + controller.getMethod().getName());

        long start = System.currentTimeMillis(); // devuelve el tiempo que ha pasado desde 01-01-1970 hasta ahora en milisegundos
        request.setAttribute("start", start);// guardamos el valor dentro del request para pasarlo

        // simulamos un delay
        Random random = new Random();
        int delay = random.nextInt(2000); // genera un valor entero entre 0 y 500
        Thread.sleep(delay);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start"); // leemos el valor que guardamos en el request
        long result = end - start;

        logger.info("Tiempo transcurrido: " + result + " milisegundos.");
        logger.info("LoadingTimeInterceptor: postHandle() saliendo ...." + ((HandlerMethod)handler).getMethod().getName());
    }
}
