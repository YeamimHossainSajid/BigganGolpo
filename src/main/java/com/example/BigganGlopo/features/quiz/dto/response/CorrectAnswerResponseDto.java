package com.example.BigganGlopo.features.quiz.dto.response;

public interface CorrectAnswerResponseDto {
    Long getId();

    String getQuestionTitle();

    String getOptionOne();

    String getOptionTwo();

    String getOptionThree();

    String getOptionFour();

    String getQuestionAnswer();
}
