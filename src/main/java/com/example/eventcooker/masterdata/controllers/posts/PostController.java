package com.example.eventcooker.masterdata.controllers.posts;

import com.example.eventcooker.masterdata.models.posts.Post;
import com.example.eventcooker.masterdata.services.posts.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/masterdata/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/")
    public @ResponseBody
    ResponseEntity<Post> savePost(@RequestBody Post post){
        try {

            return new ResponseEntity<>(
                    postService.createPost(post),
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
    ResponseEntity<Post> getPost(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    postService.findPost(id),
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
    ResponseEntity<List<Post>> getByUser(@PathVariable Long user){
        try {
            return new ResponseEntity<>(
                    postService.findByUser(user),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/employee/{employee}")
    public @ResponseBody
    ResponseEntity<List<Post>> getByEmployee(@PathVariable Long employee){
        try {
            return new ResponseEntity<>(
                    postService.findByEmployee(employee),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Post>> getPosts(){
        try {
            return new ResponseEntity<>(
                    postService.findPosts(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Post> changePost(@PathVariable Long id, @RequestBody Post post){
        try {
            return new ResponseEntity<>(
                    postService.updatePost(id, post),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @PutMapping("/approve/{id}")
    public @ResponseBody ResponseEntity<Post> changePost(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    postService.aprrovePost(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @PutMapping("/assign/{id}/{user}")
    public @ResponseBody ResponseEntity<Post> changePost(@PathVariable Long id, @PathVariable Long user){
        try {
            return new ResponseEntity<>(
                    postService.assignEmployee(id, user),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_MODIFIED
            );
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deletePost(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    postService.deletePost(id),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
