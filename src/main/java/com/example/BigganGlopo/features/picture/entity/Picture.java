package com.example.BigganGlopo.features.picture.entity;

import com.example.BigganGlopo.generic.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Picture  extends BaseEntity {
    private String url;

}
