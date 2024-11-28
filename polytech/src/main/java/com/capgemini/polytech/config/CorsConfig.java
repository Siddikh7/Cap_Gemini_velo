package com.capgemini.polytech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permettre les requêtes CORS venant de http://localhost:4200
        registry.addMapping("/**") // Applique CORS à toutes les routes
                .allowedOrigins("http://localhost:4200") // Autorise l'origine du frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Méthodes HTTP autorisées
                .allowedHeaders("*"); // Autorise tous les en-têtes
    }
}
