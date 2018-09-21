package com.sit.cloudnative.PostService.Comment;

import java.util.List;
import java.util.Optional;

import com.sit.cloudnative.PostService.Post.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService{

    @Autowired
    private CommentRepository commentRepository ;
    @Autowired
    private PostRepository postRepository ;

    public List<Comment> getCommentList(){
        List<Comment> commentList = commentRepository.findAll();
        return commentList;
    }

	public Optional<Comment> findCommentById(Long commentId) {
        Optional<Comment> commentList = commentRepository.findById(commentId);
		return commentList;
    }
    // findCommentByPostId --> ทำมิได้ครับ
    // public List<Comment> findCommentByPostId(Long postId) {
    //     // postRepository.findAllById(ids)
    //     // List<Comment> commentList = commentRepository.findAllById(postId);
        
	// 	return commentList;
	// }

	public Comment create(Comment comment) {
		return commentRepository.save(comment);
	}


}