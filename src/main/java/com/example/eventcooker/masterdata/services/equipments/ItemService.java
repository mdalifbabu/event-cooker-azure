package com.example.eventcooker.masterdata.services.equipments;

import com.example.eventcooker.masterdata.models.equipments.Item;
import com.example.eventcooker.masterdata.models.equipments.Package;
import com.example.eventcooker.masterdata.repositories.equipments.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    //POST
    public Item createItem(Item item){
        item.setCreatedOn(Instant.now());
        return itemRepository.save(item);
    }

    //GET
    public Item findItem(Long id){
        return itemRepository.findById(id).orElse(null);
    }

    //GET
    public List<Item> findByUser(Long user){
        return itemRepository.findByUser(user);
    }

    //GET ALL
    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    //PUT
    public Item updateItem(Long id, Item item){

        Item exItem = itemRepository.findById(id).orElse(null);

        assert exItem != null;
        if(item.getName() != null)
            exItem.setName(item.getName());
        if(item.getPhoto() != null)
            exItem.setPhoto(item.getPhoto());
        if(item.getDescription() != null)
            exItem.setDescription(item.getDescription());
        if(item.getRating() != 0)
            exItem.setRating(item.getRating());
        if (item.getUser() != null){
            exItem.setUser(item.getUser());
        }
        item.setModifiedOn(Instant.now());

        return itemRepository.save(exItem);
    }

    //DELETE
    public String deleteItem(Long id){
        itemRepository.deleteById(id);
        return "Successfully deleted Item which id was " + id + ":)";
    }
}
