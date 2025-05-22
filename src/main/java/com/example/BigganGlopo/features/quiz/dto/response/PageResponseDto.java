package com.example.BigganGlopo.features.quiz.dto.response;
import com.example.BigganGlopo.features.quiz.dto.request.QuizRequestDto;
import lombok.Data;

import java.util.List;

@Data
public class PageResponseDto {

    private List<QuizRequestDto>content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private Long totalElements;
    private Boolean last;

}
