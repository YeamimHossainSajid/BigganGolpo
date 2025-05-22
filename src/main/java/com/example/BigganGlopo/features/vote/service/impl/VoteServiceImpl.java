package com.example.BigganGlopo.features.vote.service.impl;

import com.example.BigganGlopo.auth.model.User;
import com.example.BigganGlopo.auth.repository.UserRepo;
import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.features.bolg.repository.BlogRepository;
import com.example.BigganGlopo.features.comment.entity.Comment;
import com.example.BigganGlopo.features.comment.repository.CommentRepository;
import com.example.BigganGlopo.features.vote.entity.Vote;
import com.example.BigganGlopo.features.vote.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServiceImpl {
    @Autowired
    private ReactionRepository reactionRepo;
    @Autowired private BlogRepository postRepo;
    @Autowired private CommentRepository commentRepo;
    @Autowired private UserRepo userRepo;

    public String togglePostReaction(Long postId, Long userId, String type) {
        User user = userRepo.findById(userId).orElseThrow();
        Blog post = postRepo.findById(postId).orElseThrow();
        Optional<Vote> existing = reactionRepo.findByUserAndPost(user, post);
        if (existing.isPresent()) {
            reactionRepo.delete(existing.get());
            return "Reaction removed";
        } else {
            Vote reaction = new Vote();
            reaction.setUser(user);
            reaction.setPost(post);
            reaction.setType(type);
            reactionRepo.save(reaction);
            return "Reaction added";
        }
    }

    public String toggleCommentReaction(Long commentId, Long userId, String type) {
        User user = userRepo.findById(userId).orElseThrow();
        Comment comment = commentRepo.findById(commentId).orElseThrow();
        Optional<Vote> existing = reactionRepo.findByUserAndComment(user, comment);
        if (existing.isPresent()) {
            reactionRepo.delete(existing.get());
            return "Reaction removed";
        } else {
            Vote reaction = new Vote();
            reaction.setUser(user);
            reaction.setComment(comment);
            reaction.setType(type);
            reactionRepo.save(reaction);
            return "Reaction added";
        }
    }
}
