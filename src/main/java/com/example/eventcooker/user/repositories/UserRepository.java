package com.example.eventcooker.user.repositories;

import com.example.eventcooker.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByProfession(String profession);
}
