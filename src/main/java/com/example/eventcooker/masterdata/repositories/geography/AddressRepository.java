package com.example.eventcooker.masterdata.repositories.geography;

import com.example.eventcooker.masterdata.models.geography.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
