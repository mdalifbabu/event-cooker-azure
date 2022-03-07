package com.example.eventcooker.user.services;

import com.example.eventcooker.masterdata.models.posts.Post;
import com.example.eventcooker.masterdata.services.geography.AddressService;
import com.example.eventcooker.masterdata.utils.AgeConverter;
import com.example.eventcooker.user.models.User;
import com.example.eventcooker.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AgeConverter ageConverter;

    //GET
    public User findUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findProfessional(String profession){
        return userRepository.findByProfession(profession);
    }

    //GET ALL
    public List<User> findUsers(){
        return userRepository.findAll();
    }

    //PUT
    public User updateUser(Long id, User user){

        User exUser = userRepository.findById(id).orElse(null);

        assert exUser != null;
        if(user.getProfession() != null)
            exUser.setProfession(user.getProfession());
        if(user.getFullName() != null)
            exUser.setFullName(user.getFullName());
        if(user.getCurrentStatus() != null)
            exUser.setCurrentStatus(user.getCurrentStatus());
        if(user.getCellphone() != null)
            exUser.setCellphone(user.getCellphone());
        if(user.getEmail() != null)
            exUser.setEmail(user.getEmail());
        if(user.getNid() != null)
            exUser.setNid(user.getNid());
        if(user.getBirthRegNo() != null)
            exUser.setBirthRegNo(user.getBirthRegNo());
        if(user.getDateOfBirth() != null)
            exUser.setDateOfBirth(user.getDateOfBirth());
        if(user.getDateOfBirth() != null)
            exUser.setAge(ageConverter.age(user.getDateOfBirth()));
        if(user.getGender() != null)
            exUser.setGender(user.getGender());
        if(user.getNationality() != null)
            exUser.setNationality(user.getNationality());
        if(user.getBloodGroup() != null)
            exUser.setBloodGroup(user.getBloodGroup());
        if(user.getMaritialStatus() != null)
            exUser.setMaritialStatus(user.getMaritialStatus());
        if(user.getAddress() != null)
            exUser.setAddress(user.getAddress());
        if(user.getWorkPhone() != null)
            exUser.setWorkPhone(user.getWorkPhone());
        if(user.getPhoto() != null)
            exUser.setPhoto(user.getPhoto());
        if(user.getAbout() != null)
            exUser.setAbout(user.getAbout());
        if(user.getDescription() != null)
            exUser.setDescription(user.getDescription());
        exUser.setModifiedOn(Instant.now());
        if(user.getModifiedBy() != null)
            exUser.setModifiedBy(user.getModifiedBy());

        return userRepository.save(exUser);
    }

    public User aprroveUser(Long id){

        User exUser = userRepository.findById(id).orElse(null);

        assert exUser != null;
        exUser.setApproval(!exUser.isApproval());
        exUser.setModifiedOn(Instant.now());

        return userRepository.save(exUser);
    }

    //DELETE
    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "Successfully deleted User which id was " + id + ":)";
    }
}
