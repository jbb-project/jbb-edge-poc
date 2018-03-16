package org.jbb.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@SpringBootApplication
public class JbbEdgeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JbbEdgeApplication.class, args);
    }

    @Bean
    public ErrorViewResolver customErrorViewResolver() {
        final ModelAndView redirectToIndexHtml = new ModelAndView("forward:/index.html", Collections.emptyMap(), HttpStatus.OK);
        return (request, status, model) -> status == HttpStatus.NOT_FOUND ? redirectToIndexHtml : null;
    }
}
