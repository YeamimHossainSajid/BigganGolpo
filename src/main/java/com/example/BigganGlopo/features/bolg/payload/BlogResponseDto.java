package com.example.BigganGlopo.features.bolg.payload;

import com.example.BigganGlopo.generic.payload.response.BaseResponseDto;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BlogResponseDto extends BaseResponseDto {
    @Size(max = 10000, message = "Text cannot be longer than 10,000 characters")
    private String description;
    private String url;
}
