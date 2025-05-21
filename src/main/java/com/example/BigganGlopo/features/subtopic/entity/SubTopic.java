package com.example.BigganGlopo.features.subtopic.entity;

import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SubTopic  extends BaseEntity {
    private String title;

    @OneToMany(mappedBy = "subTopic", cascade = CascadeType.ALL)
    private List<SubTopicElement> elements = new ArrayList<>();
}
