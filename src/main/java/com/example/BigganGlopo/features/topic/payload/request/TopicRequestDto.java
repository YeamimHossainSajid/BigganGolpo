package com.example.BigganGlopo.features.topic.payload.request;

import com.example.BigganGlopo.generic.payload.request.IDto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TopicRequestDto implements IDto {
    private String name;

    private MultipartFile url;
}
