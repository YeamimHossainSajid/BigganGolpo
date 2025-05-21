package com.example.BigganGlopo.features.subtopic.entity;

import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class SubTopic  extends BaseEntity {
    private String title;
    private String content;
}
