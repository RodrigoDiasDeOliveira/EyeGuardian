package com.eyeguardian.services;

import org.springframework.stereotype.Service;

@Service
public class RecognizedObjectService {
    public String processObject(String objectName) {
        return "Objeto reconhecido: " + objectName;
    }
}
