package com.example.BigganGlopo.features.topic.payload.response;

import com.example.BigganGlopo.generic.payload.response.BaseResponseDto;
import lombok.Data;

@Data
public class TopicResponseDto extends BaseResponseDto {

    private String name;

    private String url;

}
