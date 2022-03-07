package com.example.eventcooker.masterdata.controllers.posts;

import com.example.eventcooker.masterdata.models.posts.Confirmation;
import com.example.eventcooker.masterdata.services.posts.ConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/confirmation")
public class ConfirmationController {

    @Autowired
    private ConfirmationService confirmationService;

    @PostMapping("/")
    public @ResponseBody
    ResponseEntity<Confirmation> saveConfirmation(@RequestBody Confirmation confirmation){
        try {

            return new ResponseEntity<>(
                    confirmationService.createConfirmation(confirmation),
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
    ResponseEntity<Confirmation> getConfirmation(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    confirmationService.findConfirmation(id),
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
    ResponseEntity<List<Confirmation>> getByUser(@PathVariable Long user){
        try {
            return new ResponseEntity<>(
                    confirmationService.findByUser(user),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Confirmation>> getConfirmations(){
        try {
            return new ResponseEntity<>(
                    confirmationService.findConfirmations(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Confirmation> changeConfirmation(@PathVariable Long id, @RequestBody Confirmation confirmation){
        try {
            return new ResponseEntity<>(
                    confirmationService.updateConfirmation(id, confirmation),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteConfirmation(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    confirmationService.deleteConfirmation(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
