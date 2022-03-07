package com.example.eventcooker.masterdata.utils.auth;

import com.example.eventcooker.masterdata.models.auth.UserAllInfo;
import com.example.eventcooker.user.models.User;
import com.example.eventcooker.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserAllInfoUtil {

    @Autowired
    private UserRepository userRepository;

    //POST
    public User createUser(User user){
        user.setApproval(false);
        user.setCreatedOn(Instant.now());
        return userRepository.save(user);
    }

    public void professionChecking(UserAllInfo userAllInfo){
            User user = new User();
            user.setProfession(userAllInfo.getProfession());
            user.setFullName(userAllInfo.getFullName());
            user.setEmail(userAllInfo.getEmail());
            userAllInfo.setUserId(createUser(user).getId());
    }
}
