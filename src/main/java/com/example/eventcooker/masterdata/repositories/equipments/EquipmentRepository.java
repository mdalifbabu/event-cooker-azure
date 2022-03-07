package com.example.eventcooker.masterdata.repositories.equipments;

import com.example.eventcooker.masterdata.models.equipments.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByUser(Long user);
}
