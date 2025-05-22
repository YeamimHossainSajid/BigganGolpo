package com.example.BigganGlopo.features.subtopic.entity;

import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SubTopicElement extends BaseEntity {
    private String type;
    @Column(length = 10000)
    private String value;
    private int orderIndex;

    @ManyToOne
    private SubTopic subTopic;
}

