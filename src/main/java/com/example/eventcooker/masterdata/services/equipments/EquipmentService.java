package com.example.eventcooker.masterdata.services.equipments;

import com.example.eventcooker.masterdata.models.equipments.Equipment;
import com.example.eventcooker.masterdata.repositories.equipments.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    //POST
    public Equipment createEquipment(Equipment equipment){
        equipment.setCreatedOn(Instant.now());
        return equipmentRepository.save(equipment);
    }

    //GET
    public Equipment findEquipment(Long id){
        return equipmentRepository.findById(id).orElse(null);
    }

    //GET
    public List<Equipment> findByUser(Long user){
        return equipmentRepository.findByUser(user);
    }

    //GET ALL
    public List<Equipment> findEquipments(){
        return equipmentRepository.findAll();
    }

    //PUT
    public Equipment updateEquipment(Long id, Equipment equipment){

        Equipment exEquipment = equipmentRepository.findById(id).orElse(null);

        assert exEquipment != null;
        if(equipment.getName() != null)
            exEquipment.setName(equipment.getName());
        if(equipment.getModel() != null)
            exEquipment.setModel(equipment.getModel());
        if(equipment.getSensor() != null)
            exEquipment.setSensor(equipment.getSensor());
        if(equipment.getWireless() != null)
            exEquipment.setWireless(equipment.getWireless());
        if(equipment.getWeight() != 0.0)
            exEquipment.setWeight(equipment.getWeight());
        if(equipment.getPhoto() != null)
            exEquipment.setPhoto(equipment.getPhoto());
        if(equipment.getDescription() != null)
            exEquipment.setDescription(equipment.getDescription());
        if(equipment.getUser() != null){
            exEquipment.setUser(equipment.getUser());
        }
        equipment.setModifiedOn(Instant.now());

        return equipmentRepository.save(exEquipment);
    }

    //DELETE
    public String deleteEquipment(Long id){
        equipmentRepository.deleteById(id);
        return "Successfully deleted Equipment which id was " + id + ":)";
    }
}
