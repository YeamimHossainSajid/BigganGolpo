package com.example.BigganGlopo.features.subtopic.payload.response;

import com.example.BigganGlopo.features.subtopic.payload.response.SubTopicElementDto;
import com.example.BigganGlopo.generic.payload.response.BaseResponseDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class SubTopicResponseDto extends BaseResponseDto {
    private String title;
    private List<SubTopicElementDto> elements;

    public SubTopicResponseDto(Long id, String title, List<SubTopicElementDto> elements) {
        super(id);
        this.title = title;
        this.elements = elements;
    }
}
