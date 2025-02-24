package com.eyeguardian.service;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
    public String getCurrentLocation() {
        // Simulação de obtenção de localização
        return "Latitude: 40.7128, Longitude: -74.0060";
    }
}
