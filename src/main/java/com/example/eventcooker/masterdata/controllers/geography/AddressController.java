package com.example.eventcooker.masterdata.controllers.geography;

import com.example.eventcooker.masterdata.models.geography.Address;
import com.example.eventcooker.masterdata.services.geography.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/geography/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/")
    public @ResponseBody
    ResponseEntity<Address> saveAddress(@RequestBody Address address){
        try {
            return new ResponseEntity<>(
                    addressService.createAddress(address),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Address> getAddress(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    addressService.findAddress(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Address> changeAddress(@PathVariable Long id, @RequestBody Address address){
        try {
            return new ResponseEntity<>(
                    addressService.updateAddress(id, address),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteAddress(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    addressService.deleteAddress(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
