package com.example.BigganGlopo.features.description.entity;

import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Discription extends BaseEntity {
    private String description;
}
