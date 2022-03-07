package com.example.eventcooker.masterdata.repositories.equipments;

import com.example.eventcooker.masterdata.models.equipments.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package, Long> {
    List<Package> findByUser(Long user);
}
