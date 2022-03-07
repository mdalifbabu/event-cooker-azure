package com.example.eventcooker.masterdata.services.geography;

import com.example.eventcooker.masterdata.models.geography.District;
import com.example.eventcooker.masterdata.repositories.geography.DistrictRepository;
import com.example.eventcooker.masterdata.repositories.geography.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    //POST
    public District createDistrict(District district){
        district.setDivision(
                divisionRepository.findById(district
                        .getDivision()
                        .getId())
                        .orElse(null)
        );
        return districtRepository.save(district);
    }

    //POST ALL
    public List<District> createDistricts(List<District> districts){
        for (District district: districts){
            district.setDivision(
                    divisionRepository.findById(district
                                    .getDivision()
                                    .getId())
                            .orElse(null)
            );
        }
        return districtRepository.saveAll(districts);
    }

    //GET
    public District findDistrict(Long id){
        return districtRepository.findById(id).orElse(null);
    }

    //GET ALL
    public List<District> findDistricts(){
       return districtRepository.findAll();
    }

    //PUT
    public District updateDistrict(District district){

        District exDistrict = districtRepository.findById(district.getId()).orElse(null);

        assert exDistrict != null;
        exDistrict.setName(district.getName());

        return districtRepository.save(exDistrict);
    }

    //DELETE
    public String deleteDistrict(Long id){
        districtRepository.deleteById(id);
        return "Successfully deleted District which id was " + id + ":)";
    }

    //DELETE ALL
    public String deleteDistricts(){
        districtRepository.deleteAll();
        return "Successfully deleted all District :)";
    }
}
