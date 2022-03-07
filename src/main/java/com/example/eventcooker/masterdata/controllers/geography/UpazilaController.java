package com.example.eventcooker.masterdata.controllers.geography;

import com.example.eventcooker.masterdata.models.geography.Upazila;
import com.example.eventcooker.masterdata.services.geography.UpazilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/geography/upazila")
public class UpazilaController {

    @Autowired
    private UpazilaService upazilaService;


    @PostMapping("/add")
    public @ResponseBody
    ResponseEntity<Upazila> saveUpazila(@RequestBody Upazila upazila){
        try {
            return new ResponseEntity<>(
                    upazilaService.createUpazila(upazila),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @PostMapping("/add-all")
    public @ResponseBody ResponseEntity<List<Upazila>> saveUpazilas(@RequestBody List<Upazila> upazilas){
        try {
            return new ResponseEntity<>(
                    upazilaService.createUpazilas(upazilas),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<Upazila> getUpazila(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    upazilaService.findUpazila(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/get-all")
    public @ResponseBody ResponseEntity<List<Upazila>> getUpazilas(){
        try {
            return new ResponseEntity<>(
                    upazilaService.findUpazilas(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<Upazila> changeUpazila(@RequestBody Upazila upazila){
        try {
            return new ResponseEntity<>(
                    upazilaService.updateUpazila(upazila),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<String> deleteUpazila(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    upazilaService.deleteUpazila(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @DeleteMapping("/delete-all")
    public @ResponseBody ResponseEntity<String> deleteUpazilas(){
        try {
            return new ResponseEntity<>(
                    upazilaService.deleteUpazilas(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT
            );
        }
    }
}
