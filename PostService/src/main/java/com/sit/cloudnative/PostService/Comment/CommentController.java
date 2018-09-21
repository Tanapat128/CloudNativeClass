package com.sit.cloudnative.PostService.Comment;

import java.util.List;

import javax.validation.Valid;

import com.sit.cloudnative.PostService.Post.PostService;
import com.sit.cloudnative.PostService.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    // Get all comments in all posts
    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> getCommentList() {
        List<Comment> commentList = commentService.getCommentList();
        return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);
    }

    // Get a comment by commentID
    @GetMapping(value = "/comments/{comment_id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "comment_id") Long comment_id) {
        Comment comment = commentService.findCommentById(comment_id).get();
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    // Create a comment to a post
    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable(value = "postId") Long postId, @Valid @RequestBody Comment comment) {
        return postService.getPostById(postId).map(post -> {
            comment.setPost(post);
            comment.setUser(userService.getUserById(1).get());
            return commentService.create(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    // Get all comments in 1 post(GetCommentByPostId)
    // @GetMapping(value = "/posts/{post_id}/comments")
    // public List<Comment> getAllCommentInOnePost(@PathVariable(value = "post_id")
    // Long post_id) {
    // return postService.getPostById(post_id).map(post -> {
    // post.
    // });
    // }

    // //Get 1 comment in 1 post
    // @GetMapping(value = "/posts/{post_id}/comments/{comment_id}")
    // public ResponseEntity<Comment> getCommentById(){

    // }

}