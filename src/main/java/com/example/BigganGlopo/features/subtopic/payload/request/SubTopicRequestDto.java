package com.example.BigganGlopo.features.subtopic.payload.request;

import com.example.BigganGlopo.generic.payload.request.IDto;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SubTopicRequestDto implements IDto {
    private String title;
    @Size(max = 10000, message = "Text cannot be longer than 10,000 characters")
    private String content;
    private Long topicId;
}
