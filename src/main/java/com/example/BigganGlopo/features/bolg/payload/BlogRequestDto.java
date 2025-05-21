package com.example.BigganGlopo.features.bolg.payload;

import com.example.BigganGlopo.generic.payload.request.IDto;
import lombok.Data;

@Data
public class BlogRequestDto implements IDto {
    private String description;
    private String url;
}
