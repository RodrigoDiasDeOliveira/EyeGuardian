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



