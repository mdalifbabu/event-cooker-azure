package com.example.eventcooker.masterdata.services.posts;

import com.example.eventcooker.masterdata.models.posts.Post;
import com.example.eventcooker.masterdata.repositories.posts.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    //POST
    public Post createPost(Post post){
        post.setCreatedOn(Instant.now());
        return postRepository.save(post);
    }

    //GET
    public Post findPost(Long id){
        return postRepository.findById(id).orElse(null);
    }

    //GET
    public List<Post> findByUser(Long user){
        return postRepository.findByUser(user);
    }

    public List<Post> findByEmployee(Long employee){
        return postRepository.findByEmployee(employee);
    }

    //GET ALL
    public List<Post> findPosts(){
        return postRepository.findAll();
    }

    //PUT
    public Post updatePost(Long id, Post post){

        Post exPost = postRepository.findById(id).orElse(null);

        assert exPost != null;
        if(post.getTitle() != null)
            exPost.setTitle(post.getTitle());
        if(post.getPhoto() != null)
            exPost.setPhoto(post.getPhoto());
        if(post.getDescription() != null)
            exPost.setDescription(post.getDescription());
        exPost.setModifiedOn(Instant.now());

        return postRepository.save(exPost);
    }

    public Post aprrovePost(Long id){

        Post exPost = postRepository.findById(id).orElse(null);

        assert exPost != null;
        exPost.setApproval(!exPost.isApproval());
        exPost.setModifiedOn(Instant.now());

        return postRepository.save(exPost);
    }

    public Post assignEmployee(Long id, Long user){

        Post exPost = postRepository.findById(id).orElse(null);

        assert exPost != null;
        exPost.setEmployee(user);
        exPost.setModifiedOn(Instant.now());

        return postRepository.save(exPost);
    }

    //DELETE
    public String deletePost(Long id){
        postRepository.deleteById(id);
        return "Successfully deleted Post which id was " + id + ":)";
    }
}
