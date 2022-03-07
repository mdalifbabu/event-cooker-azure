package com.example.eventcooker.masterdata.services.geography;

import com.example.eventcooker.masterdata.models.geography.Address;
import com.example.eventcooker.masterdata.repositories.geography.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    //POST
    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    //GET ALL
    public Address findAddress(Long id){
        return addressRepository.findById(id).orElse(null);
    }

    //PUT
    public Address updateAddress(Long id, Address address){

        Address exAddress = addressRepository.findById(id).orElse(null);

        assert exAddress != null;
        if(address.getStreet() != null)
            exAddress.setStreet(address.getStreet());
        if(address.getPostOffice() != null)
            exAddress.setPostOffice(address.getPostOffice());
        if(address.getPostalCode() != null)
            exAddress.setPostalCode(address.getPostalCode());
        if(address.getDivision() != null)
            exAddress.setDivision(address.getDivision());
        if(address.getDistrict() != null)
            exAddress.setDistrict(address.getDistrict());
        if(address.getUpazila() != null)
            exAddress.setUpazila(address.getUpazila());

        return addressRepository.save(exAddress);
        //return exAddress;
    }

    //DELETE
    public String deleteAddress(Long id){
        addressRepository.deleteById(id);
        return "Successfully deleted Address which id was " + id + ":)";
    }
}
