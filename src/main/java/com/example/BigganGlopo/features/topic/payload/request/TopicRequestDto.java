package com.example.BigganGlopo.features.topic.payload.request;

import com.example.BigganGlopo.generic.payload.request.IDto;
import lombok.Data;

@Data
public class TopicRequestDto implements IDto {
    private String name;

    private String url;
}
