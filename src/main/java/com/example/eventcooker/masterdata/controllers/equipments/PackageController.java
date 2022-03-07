package com.example.eventcooker.masterdata.controllers.equipments;

import com.example.eventcooker.masterdata.models.equipments.Package;
import com.example.eventcooker.masterdata.models.posts.Post;
import com.example.eventcooker.masterdata.services.equipments.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/package")
public class PackageController {
    @Autowired
    private PackageService packageService;

    @PostMapping("/")
    public @ResponseBody
    ResponseEntity<Package> savePackage(@RequestBody Package ppackage){
        try {

            return new ResponseEntity<>(
                    packageService.createPackage(ppackage),
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
    ResponseEntity<Package> getPackage(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    packageService.findPackage(id),
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
    ResponseEntity<List<Package>> getByUser(@PathVariable Long user){
        try {
            return new ResponseEntity<>(
                    packageService.findByUser(user),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Package>> getPackages(){
        try {
            return new ResponseEntity<>(
                    packageService.findPackages(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Package> changePackage(@PathVariable Long id, @RequestBody Package ppackage){
        try {
            return new ResponseEntity<>(
                    packageService.updatePackage(id, ppackage),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deletePackage(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    packageService.deletePackage(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
