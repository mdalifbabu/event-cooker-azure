package com.example.eventcooker.masterdata.utils.geography;

import com.example.eventcooker.masterdata.models.geography.District;
import com.example.eventcooker.masterdata.models.geography.Division;
import com.example.eventcooker.masterdata.models.geography.Upazila;
import com.example.eventcooker.masterdata.services.geography.DistrictService;
import com.example.eventcooker.masterdata.services.geography.DivisionService;
import com.example.eventcooker.masterdata.services.geography.UpazilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CSVParser {

    private String basePath = "src/main/java/com/example/eventcooker/masterdata/utils/geography/csv";

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private UpazilaService upazilaService;

    public List<List<String>> csvReader(String path) {
        List<List<String>> records = new ArrayList<>();
        String COMMA_DELIMITER = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
            return records;
        } catch (IOException ioException){
            return (List<List<String>>) ioException;
        }
    }

    public void csvProcess() {

        //Division
        File appBase = new File(basePath);
        String path = appBase.getAbsolutePath();
        List<List<String>> records = csvReader(path  + "/divisions.csv");
        List<Division> divisions = new ArrayList<>();

        records.remove(0);
        for (List<String> div : records) {
            Division division = new Division();
            division.setId((long) Integer.parseInt(div.get(0)));
            division.setName(div.get(1));
            divisions.add(division);
        }
        divisionService.createDivisions(divisions);

        //District
        records.clear();

        appBase = new File(basePath);
        path = appBase.getAbsolutePath();
        records = csvReader(path + "/districts.csv");
        List<District> districts = new ArrayList<>();

        records.remove(0);
        for (List<String> dist : records) {
            District district = new District();
            district.setDivision(new Division());
            district.setId((long) Integer.parseInt(dist.get(0)));
            district.setName(dist.get(1));
            district.getDivision().setId((long) Integer.parseInt(dist.get(2)));
            districts.add(district);
        }
        districtService.createDistricts(districts);

        //Upazila
        records.clear();

        appBase = new File(basePath);
        path = appBase.getAbsolutePath();
        records = csvReader(path  + "/upazilas.csv");
        List<Upazila> upazilas = new ArrayList<>();

        records.remove(0);
        for (List<String> upz : records) {
            Upazila upazila = new Upazila();
            upazila.setDistrict(new District());
            upazila.setId((long) Integer.parseInt(upz.get(0)));
            upazila.setName(upz.get(1));
            upazila.getDistrict().setId((long) Integer.parseInt(upz.get(2)));
            upazilas.add(upazila);
        }
        upazilaService.createUpazilas(upazilas);
    }
}
