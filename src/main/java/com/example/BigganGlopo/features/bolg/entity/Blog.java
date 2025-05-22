package com.example.BigganGlopo.features.bolg.entity;

import com.example.BigganGlopo.auth.model.User;
import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Blog extends BaseEntity {
    @ManyToOne
    private User user;
    @Column(length = 10000)
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
}
