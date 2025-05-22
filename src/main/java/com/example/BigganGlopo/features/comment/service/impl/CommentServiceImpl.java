package com.example.BigganGlopo.features.comment.service.impl;

import com.example.BigganGlopo.auth.model.User;
import com.example.BigganGlopo.auth.repository.UserRepo;
import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.features.bolg.repository.BlogRepository;
import com.example.BigganGlopo.features.comment.entity.Comment;
import com.example.BigganGlopo.features.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl {
    @Autowired
    private CommentRepository commentRepo;
    @Autowired private BlogRepository postRepo;
    @Autowired private UserRepo userRepo;

    public Comment addComment(Long postId, Long userId, String content, Long parentCommentId) {
        Blog post = postRepo.findById(postId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUser(user);
        comment.setContent(content);
        if (parentCommentId != null) {
            Comment parent = commentRepo.findById(parentCommentId).orElseThrow();
            comment.setParentComment(parent);
        }
        return commentRepo.save(comment);
    }
}
