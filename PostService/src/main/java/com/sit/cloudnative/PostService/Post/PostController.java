package com.sit.cloudnative.PostService.Post;

import java.util.List;


import javax.validation.Valid;

import com.sit.cloudnative.PostService.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    // create a post
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        return new ResponseEntity<Post>(userService.getUserById(1).map(user -> {
            post.setUser(user);
            return postService.create(post);
        }).orElseThrow(() -> new ResourceNotFoundException("This UserId doesn't not found")), HttpStatus.OK);
    }

    // find a post by post_id
    @RequestMapping(value = "/posts/{post_id}", method = RequestMethod.GET)
    public ResponseEntity<Post> createPost(@PathVariable(value = "post_id") Long post_id) {
        Post post_object = postService.getPostById(post_id).get();
        return new ResponseEntity<Post>(post_object, HttpStatus.OK);
    }

    // find all post
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getPostList() {
        List<Post> post_object = postService.getAllPosts();
        return new ResponseEntity<List<Post>>(post_object, HttpStatus.OK);
    }

}