package com.example.eventcooker.masterdata.controllers.equipments;

import com.example.eventcooker.masterdata.models.equipments.Equipment;
import com.example.eventcooker.masterdata.models.posts.Post;
import com.example.eventcooker.masterdata.services.equipments.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/")
    public @ResponseBody ResponseEntity<Equipment> saveEquipment(@RequestBody Equipment equipment){
        try {

            return new ResponseEntity<>(
                    equipmentService.createEquipment(equipment),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Equipment> getEquipment(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    equipmentService.findEquipment(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/user/{user}")
    public @ResponseBody
    ResponseEntity<List<Equipment>> getByUser(@PathVariable Long user){
        try {
            return new ResponseEntity<>(
                    equipmentService.findByUser(user),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Equipment>> getEquipments(){
        try {
            return new ResponseEntity<>(
                    equipmentService.findEquipments(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Equipment> changeEquipment(@PathVariable Long id, @RequestBody Equipment equipment){
        try {
            return new ResponseEntity<>(
                    equipmentService.updateEquipment(id, equipment),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteEquipment(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    equipmentService.deleteEquipment(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
