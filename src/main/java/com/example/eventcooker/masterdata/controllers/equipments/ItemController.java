package com.example.eventcooker.masterdata.controllers.equipments;

import com.example.eventcooker.masterdata.models.equipments.Item;
import com.example.eventcooker.masterdata.models.posts.Post;
import com.example.eventcooker.masterdata.services.equipments.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/")
    public @ResponseBody ResponseEntity<Item> saveItem(@RequestBody Item item){
        try {

            return new ResponseEntity<>(
                    itemService.createItem(item),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Item> getItem(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    itemService.findItem(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/user/{user}")
    public @ResponseBody
    ResponseEntity<List<Item>> getByUser(@PathVariable Long user){
        try {
            return new ResponseEntity<>(
                    itemService.findByUser(user),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Item>> getItems(){
        try {
            return new ResponseEntity<>(
                    itemService.findItems(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Item> changeItem(@PathVariable Long id, @RequestBody Item item){
        try {
            return new ResponseEntity<>(
                    itemService.updateItem(id, item),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteItem(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    itemService.deleteItem(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
