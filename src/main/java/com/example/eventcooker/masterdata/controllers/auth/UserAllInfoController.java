package com.example.eventcooker.masterdata.controllers.auth;

import com.example.eventcooker.masterdata.models.auth.UserAllInfo;
import com.example.eventcooker.masterdata.services.auth.UserAllInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/auth/user/all/info")
public class UserAllInfoController {

    @Autowired
    private UserAllInfoService userAllInfoService;

    @PostMapping("/")
    public @ResponseBody ResponseEntity<?> saveUserAllInfo(@RequestBody UserAllInfo userAllInfo){
        try {
            UserAllInfo userAllInfo1 = userAllInfoService.findUserAllInfoByUserName(userAllInfo.getUserName());
            if(userAllInfo1 != null){
                return new ResponseEntity<>(
                        "Username already exist!!",
                        HttpStatus.NOT_FOUND
                );
            }

            System.out.println("ALif");
            return new ResponseEntity<>(
                    userAllInfoService.createUserAllInfo(userAllInfo),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @GetMapping("/user/{userName}")
    public @ResponseBody ResponseEntity<UserAllInfo> getUserAllInfoByUserName(@PathVariable String userName){
        try {
            return new ResponseEntity<>(
                    userAllInfoService.findUserAllInfoByUserName(userName),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<UserAllInfo> getUserAllInfo(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    userAllInfoService.findUserAllInfo(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }


    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<?> changeUserAllInfo(@PathVariable Long id, @RequestBody UserAllInfo userAllInfo){
        try {
            UserAllInfo userAllInfo1 = userAllInfoService.findUserAllInfoByUserName(userAllInfo.getUserName());
            if(userAllInfo1 != null){
                return new ResponseEntity<>(
                        "Username already exist!!",
                        HttpStatus.NOT_FOUND
                );
            }
            return new ResponseEntity<>(
                    userAllInfoService.updateUserAllInfo(id, userAllInfo),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<String> deleteUserAllInfo(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    userAllInfoService.deleteUserAllInfo(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
