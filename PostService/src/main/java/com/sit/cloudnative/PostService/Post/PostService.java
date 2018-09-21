package com.sit.cloudnative.PostService.Post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService{

    @Autowired
    private PostRepository postRepository;

    public Post create(Post post){
        return postRepository.save(post);
    }
    public List<Post> getAllPosts(){
        List<Post> post =  postRepository.findAll();
        return post;
    }
	public Optional<Post> getPostById(long id) {
        Optional<Post> post = postRepository.findById(id);
		return post;
    }
    

}