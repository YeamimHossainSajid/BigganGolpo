package com.example.BigganGlopo.features.quiz.dto.request;

import java.time.LocalDateTime;

public record QuizResultRequestDto(

    Long userId,

    Long quizSessionId,

    Long questionId,

    Boolean isCorrect,

    String answer,

    LocalDateTime time

) {

}
