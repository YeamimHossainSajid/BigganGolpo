package com.example.BigganGlopo.features.vote.entity;

import com.example.BigganGlopo.auth.model.User;
import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.features.comment.entity.Comment;
import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Vote extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Blog post;

    @ManyToOne
    private Comment comment;

    private String type;
    private LocalDateTime createdAt = LocalDateTime.now();
}
