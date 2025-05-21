package com.example.BigganGlopo.features.bolg.payload;

import com.example.BigganGlopo.generic.payload.response.BaseResponseDto;
import lombok.Data;

@Data
public class BlogResponseDto extends BaseResponseDto {
    private String description;
    private String url;
}
