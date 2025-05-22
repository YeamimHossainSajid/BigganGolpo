package com.example.BigganGlopo.features.comment.entity;

import com.example.BigganGlopo.auth.model.User;
import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Comment extends BaseEntity {
    @ManyToOne
    private Blog post;

    @ManyToOne
    private Comment parentComment;

    @ManyToOne
    private User user;

    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
}
