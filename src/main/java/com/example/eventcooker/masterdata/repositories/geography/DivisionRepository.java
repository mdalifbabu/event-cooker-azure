package com.example.eventcooker.masterdata.repositories.geography;

import com.example.eventcooker.masterdata.models.geography.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Long> {
}
