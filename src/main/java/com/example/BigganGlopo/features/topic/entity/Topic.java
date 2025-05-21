package com.example.BigganGlopo.features.topic.entity;

import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
public class Topic extends BaseEntity {

    private String name;

    private String url;
}
