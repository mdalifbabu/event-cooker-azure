package com.example.eventcooker.user.controllers;

import com.example.eventcooker.masterdata.models.posts.Post;
import com.example.eventcooker.user.services.UserService;
import com.example.eventcooker.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<User> getUser(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    userService.findUser(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/{profession}")
    public @ResponseBody ResponseEntity<List<User>> getProfessional(@PathVariable String profession){
        try {
            return new ResponseEntity<>(
                    userService.findProfessional(profession),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<User>> getUsers(){
        try {
            return new ResponseEntity<>(
                    userService.findUsers(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<User> changeUser(@PathVariable Long id, @RequestBody User user){
        try {
            return new ResponseEntity<>(
                    userService.updateUser(id, user),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @PutMapping("/approve/{id}")
    public @ResponseBody ResponseEntity<User> changeUser(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    userService.aprroveUser(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    userService.deleteUser(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
