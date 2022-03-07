package com.example.eventcooker.masterdata.services.auth;

import com.example.eventcooker.masterdata.models.auth.UserAllInfo;
import com.example.eventcooker.masterdata.repositories.auth.UserAllInfoRepository;
import com.example.eventcooker.masterdata.utils.auth.UserAllInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserAllInfoService {

    @Autowired
    private UserAllInfoRepository userAllInfoRepository;

    @Autowired
    private UserAllInfoUtil userAllInfoUtil;

    //POST
    public UserAllInfo createUserAllInfo(UserAllInfo userAllInfo){
        userAllInfoUtil.professionChecking(userAllInfo);
        return userAllInfoRepository.save(userAllInfo);
    }

    //GET
    public UserAllInfo findUserAllInfo(Long id){
        return userAllInfoRepository.findById(id).orElse(null);
    }

    public UserAllInfo findUserAllInfoByUserName(String userName){
        return userAllInfoRepository.findByUserName(userName);
    }

    //GET ALL
    public List<UserAllInfo> findUserAllInfos(){
        return userAllInfoRepository.findAll();
    }

    //PUT
    public UserAllInfo updateUserAllInfo(Long id, UserAllInfo userAllInfo){

        UserAllInfo exUserAllInfo = userAllInfoRepository.findById(id).orElse(null);

        assert exUserAllInfo != null;
        if(userAllInfo.getUserName() != null)
            exUserAllInfo.setUserName(userAllInfo.getUserName());
        if(userAllInfo.getUserPassword() != null)
            exUserAllInfo.setUserPassword(userAllInfo.getUserPassword());

        return userAllInfoRepository.save(exUserAllInfo);
    }

    //DELETE
    public String deleteUserAllInfo(Long id){
        userAllInfoRepository.deleteById(id);
        return "Successfully deleted UserAllInfo which id was " + id + ":)";
    }
}
