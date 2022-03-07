package com.example.eventcooker.masterdata.services.equipments;

import com.example.eventcooker.masterdata.models.equipments.Package;
import com.example.eventcooker.masterdata.repositories.equipments.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PackageService {
    @Autowired
    private PackageRepository packageRepository;

    //POST
    public Package createPackage(Package ppackage){
        ppackage.setCreatedOn(Instant.now());
        return packageRepository.save(ppackage);
    }

    //GET
    public Package findPackage(Long id){
        return packageRepository.findById(id).orElse(null);
    }

    //GET
    public List<Package> findByUser(Long user){
        return packageRepository.findByUser(user);
    }

    //GET ALL
    public List<Package> findPackages(){
        return packageRepository.findAll();
    }

    //PUT
    public Package updatePackage(Long id, Package ppackage){

        Package exPackage = packageRepository.findById(id).orElse(null);

        assert exPackage != null;
        if(ppackage.getName() != null)
            exPackage.setName(ppackage.getName());
        if(ppackage.getPhoto() != null)
            exPackage.setPhoto(ppackage.getPhoto());
        if(ppackage.getElement() != null)
            exPackage.setElement(ppackage.getElement());
        if(ppackage.getDescription() != null)
            exPackage.setDescription(ppackage.getDescription());
        if(ppackage.getRating() != 0)
            exPackage.setRating(ppackage.getRating());
        if (ppackage.getUser() != null){
            exPackage.setUser(ppackage.getUser());
        }
        ppackage.setModifiedOn(Instant.now());

        return packageRepository.save(exPackage);
    }

    //DELETE
    public String deletePackage(Long id){
        packageRepository.deleteById(id);
        return "Successfully deleted Package which id was " + id + ":)";
    }
}
