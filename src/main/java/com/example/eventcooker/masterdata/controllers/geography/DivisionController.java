package com.example.eventcooker.masterdata.controllers.geography;

import com.example.eventcooker.masterdata.models.geography.Division;
import com.example.eventcooker.masterdata.services.geography.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/geography/division")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;


    @PostMapping("/add")
    public @ResponseBody ResponseEntity<Division> saveDivision(@RequestBody Division division){
        try {
            return new ResponseEntity<>(
                    divisionService.createDivision(division),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @PostMapping("/add-all")
    public @ResponseBody ResponseEntity<List<Division>> saveDivisions(@RequestBody List<Division> divisions){
        try {
            return new ResponseEntity<>(
                    divisionService.createDivisions(divisions),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<Division> getDivision(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    divisionService.findDivision(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/get-all")
    public @ResponseBody ResponseEntity<List<Division>> getDivisions(){
        System.out.println("alif");
        try {
            return new ResponseEntity<>(
                    divisionService.findDivisions(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<Division> changeDivision(@RequestBody Division division){
        try {
            return new ResponseEntity<>(
                    divisionService.updateDivision(division),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<String> deleteDivision(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    divisionService.deleteDivision(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @DeleteMapping("/delete-all")
    public @ResponseBody ResponseEntity<String> deleteDivisions(){
        try {
            return new ResponseEntity<>(
                    divisionService.deleteDivisions(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT
            );
        }
    }
}