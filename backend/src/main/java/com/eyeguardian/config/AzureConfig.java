package com.eyeguardian.service;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureConfig {
    @Bean
    public String azureConnection() {
        // Simulação de configuração de conexão com Azure
        return "Azure Connection Initialized";
    }
}
