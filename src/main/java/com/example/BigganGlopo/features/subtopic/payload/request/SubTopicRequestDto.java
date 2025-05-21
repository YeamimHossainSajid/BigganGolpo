package com.example.BigganGlopo.features.subtopic.payload.request;

import com.example.BigganGlopo.generic.payload.request.IDto;
import lombok.Data;

@Data
public class SubTopicRequestDto implements IDto {
    private String title;
    private String content;
}
