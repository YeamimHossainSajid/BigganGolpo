package com.example.BigganGlopo.features.vote.repository;

import com.example.BigganGlopo.auth.model.User;
import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.features.comment.entity.Comment;
import com.example.BigganGlopo.features.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findByUserAndPost(User user, Blog post);
    Optional<Vote> findByUserAndComment(User user, Comment comment);
    List<Vote> findByPostId(Long postId);
    List<Vote> findByCommentId(Long commentId);
}
