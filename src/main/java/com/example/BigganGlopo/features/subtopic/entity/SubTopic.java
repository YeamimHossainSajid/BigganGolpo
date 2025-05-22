package com.example.BigganGlopo.features.subtopic.entity;

import com.example.BigganGlopo.features.topic.entity.Topic;
import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SubTopic  extends BaseEntity {
    private String title;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @OneToMany(mappedBy = "subTopic", cascade = CascadeType.ALL)
    private List<SubTopicElement> elements = new ArrayList<>();
}
