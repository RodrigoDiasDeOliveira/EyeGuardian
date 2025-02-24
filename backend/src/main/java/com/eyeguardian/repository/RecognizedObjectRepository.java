package com.eyeguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eyeguardian.model.RecognizedObject;

public interface RecognizedObjectRepository extends JpaRepository<RecognizedObject, Long> {
}
