package com.example.eventcooker.masterdata.services.geography;

import com.example.eventcooker.masterdata.models.geography.Upazila;
import com.example.eventcooker.masterdata.repositories.geography.UpazilaRepository;
import com.example.eventcooker.masterdata.repositories.geography.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpazilaService {

    @Autowired
    private UpazilaRepository upazilaRepository;

    @Autowired
    private DistrictRepository districtRepository;

    //POST
    public Upazila createUpazila(Upazila upazila){
        upazila.setDistrict(
                districtRepository.findById(upazila
                                .getDistrict()
                                .getId())
                        .orElse(null)
        );
        return upazilaRepository.save(upazila);
    }

    //POST ALL
    public List<Upazila> createUpazilas(List<Upazila> upazilas){
        for (Upazila upazila: upazilas){
            upazila.setDistrict(
                    districtRepository.findById(upazila
                                    .getDistrict()
                                    .getId())
                            .orElse(null)
            );
        }
        return upazilaRepository.saveAll(upazilas);
    }

    //GET
    public Upazila findUpazila(Long id){
        return upazilaRepository.findById(id).orElse(null);
    }

    //GET ALL
    public List<Upazila> findUpazilas(){
        return upazilaRepository.findAll();
    }

    //PUT
    public Upazila updateUpazila(Upazila upazila){

        Upazila exUpazila = upazilaRepository.findById(upazila.getId()).orElse(null);

        assert exUpazila != null;
        exUpazila.setName(upazila.getName());

        return upazilaRepository.save(exUpazila);
    }

    //DELETE
    public String deleteUpazila(Long id){
        upazilaRepository.deleteById(id);
        return "Successfully deleted Upazila which id was " + id + ":)";
    }

    //DELETE ALL
    public String deleteUpazilas(){
        upazilaRepository.deleteAll();
        return "Successfully deleted all Upazila :)";
    }
}
