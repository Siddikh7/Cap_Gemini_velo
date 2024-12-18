package com.capgemini.polytech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration CORS pour permettre les requêtes cross-origin.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configure les mappings CORS.
     *
     * @param registry le registre CORS
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Autorise les requêtes provenant de cette origine
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Autorise ces méthodes HTTP
                .allowedHeaders("*"); // Autorise tous les en-têtes
    }
}