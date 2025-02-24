package com.eyeguardian.service;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Service
public class AudioFeedbackService {
    public void provideFeedback(String message) {
        // Simulação de saída de áudio
        System.out.println("Audio Feedback: " + message);
    }
}

@Service
public class LocationService {
    public String getCurrentLocation() {
        // Simulação de obtenção de localização
        return "Latitude: 40.7128, Longitude: -74.0060";
    }
}

@Configuration
public class AzureConfig {
    @Bean
    public String azureConnection() {
        // Simulação de configuração de conexão com Azure
        return "Azure Connection Initialized";
    }
}
