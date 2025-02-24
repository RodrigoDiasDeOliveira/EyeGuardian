package com.eyeguardian.controller;

import com.eyeguardian.model.RecognizedObject;
import com.eyeguardian.repository.RecognizedObjectRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/recognized-objects")
public class RecognizedObjectController {

    private final RecognizedObjectRepository repository;

    public RecognizedObjectController(RecognizedObjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<RecognizedObject> getRecognizedObjects() {
        return repository.findAll();
    }

    @PostMapping
    public RecognizedObject createRecognizedObject(@Valid @RequestBody RecognizedObject recognizedObject) {
        return repository.save(recognizedObject);
    }

    @GetMapping("/{id}")
    public RecognizedObject getRecognizedObjectById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Object not found"));
    }

    @PutMapping("/{id}")
    public RecognizedObject updateRecognizedObject(@PathVariable Long id, @Valid @RequestBody RecognizedObject updatedObject) {
        return repository.findById(id).map(object -> {
            object.setName(updatedObject.getName());
            object.setDescription(updatedObject.getDescription());
            return repository.save(object);
        }).orElseThrow(() -> new RuntimeException("Object not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteRecognizedObject(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}