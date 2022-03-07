package com.example.eventcooker.masterdata.services.posts;

import com.example.eventcooker.masterdata.models.posts.Confirmation;
import com.example.eventcooker.masterdata.repositories.posts.ConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ConfirmationService {

    @Autowired
    private ConfirmationRepository confirmationRepository;

    //Confirmation
    public Confirmation createConfirmation(Confirmation confirmation){
        confirmation.setCreatedOn(Instant.now());
        return confirmationRepository.save(confirmation);
    }

    //GET
    public Confirmation findConfirmation(Long id){
        return confirmationRepository.findById(id).orElse(null);
    }

    //GET
    public List<Confirmation> findByUser(Long user){
        return confirmationRepository.findByUserId(user);
    }

    //GET ALL
    public List<Confirmation> findConfirmations(){
        return confirmationRepository.findAll();
    }

    //PUT
    public Confirmation updateConfirmation(Long id, Confirmation confirmation){

        Confirmation exConfirmation = confirmationRepository.findById(id).orElse(null);

        assert exConfirmation != null;
        if(confirmation.getProfId() != null){
            exConfirmation.setProfId(confirmation.getProfId());
            exConfirmation.setModifiedOn(Instant.now());
        }

        return confirmationRepository.save(exConfirmation);
    }

    //DELETE
    public String deleteConfirmation(Long id){
        confirmationRepository.deleteById(id);
        return "Successfully deleted confirmation which id was " + id + ":)";
    }
}
