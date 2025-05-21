package com.example.BigganGlopo.features.bolg.entity;

import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Blog extends BaseEntity {
    private String description;
    private String url;
}
