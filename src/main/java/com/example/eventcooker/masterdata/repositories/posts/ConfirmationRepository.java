package com.example.eventcooker.masterdata.repositories.posts;

import com.example.eventcooker.masterdata.models.posts.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {
    List<Confirmation> findByUserId(Long userId);
}
