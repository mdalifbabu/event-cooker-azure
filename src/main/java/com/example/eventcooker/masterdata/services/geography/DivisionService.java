package com.example.eventcooker.masterdata.services.geography;

import com.example.eventcooker.masterdata.models.geography.Division;
import com.example.eventcooker.masterdata.repositories.geography.DivisionRepository;
import com.example.eventcooker.masterdata.utils.geography.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired CSVParser csvParser;

    //POST
    public Division createDivision(Division division){
        return divisionRepository.save(division);
    }

    //POST ALL
    public List<Division> createDivisions(List<Division> divisions){
        return divisionRepository.saveAll(divisions);
    }

    //GET
    public Division findDivision(Long id){
        return divisionRepository.findById(id).orElse(null);
    }

    //GET ALL
    public List<Division> findDivisions(){
        if(divisionRepository.findAll().isEmpty()){
            System.out.println("alif");
            csvParser.csvProcess();
        }
        return divisionRepository.findAll();
    }

    //PUT
    public Division updateDivision(Division division){

        Division exDivision = divisionRepository.findById(division.getId()).orElse(null);

        assert exDivision != null;
        exDivision.setName(division.getName());

        return divisionRepository.save(exDivision);
    }

    //DELETE
    public String deleteDivision(Long id){
        System.out.println("Alif");
        divisionRepository.deleteById(id);
        return "Successfully deleted division which id was " + id + ":)";
    }

    //DELETE ALL
    public String deleteDivisions(){
        divisionRepository.deleteAll();
        return "Successfully deleted all division :)";
    }
}
