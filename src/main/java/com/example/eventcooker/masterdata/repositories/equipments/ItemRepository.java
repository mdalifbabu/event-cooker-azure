package com.example.eventcooker.masterdata.repositories.equipments;

import com.example.eventcooker.masterdata.models.equipments.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByUser(Long user);
}
