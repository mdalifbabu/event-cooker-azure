package com.example.eventcooker.masterdata.controllers.geography;

import com.example.eventcooker.masterdata.models.geography.District;
import com.example.eventcooker.masterdata.services.geography.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/geography/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;


    @PostMapping("/add")
    public @ResponseBody ResponseEntity<District> saveDistrict(@RequestBody District district){
        try {
            return new ResponseEntity<>(
                    districtService.createDistrict(district),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @PostMapping("/add-all")
    public @ResponseBody ResponseEntity<List<District>> saveDistricts(@RequestBody List<District> districts){
        try {
            return new ResponseEntity<>(
                    districtService.createDistricts(districts),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<District> getDistrict(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    districtService.findDistrict(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/get-all")
    public @ResponseBody ResponseEntity<List<District>> getDistricts(){
        try {
            return new ResponseEntity<>(
                    districtService.findDistricts(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<District> changeDistrict(@RequestBody District district){
        try {
            return new ResponseEntity<>(
                    districtService.updateDistrict(district),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<String> deleteDistrict(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    districtService.deleteDistrict(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @DeleteMapping("/delete-all")
    public @ResponseBody ResponseEntity<String> deleteDistricts(){
        try {
            return new ResponseEntity<>(
                    districtService.deleteDistricts(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT
            );
        }
    }
}
