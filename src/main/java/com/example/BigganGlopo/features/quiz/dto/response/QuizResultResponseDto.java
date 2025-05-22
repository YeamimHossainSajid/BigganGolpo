package com.example.BigganGlopo.features.quiz.dto.response;

public  interface QuizResultResponseDto {
    Long getId();

    Boolean getIsCorrect();

    String getUserAnswer();

    QuizSessionResponse getQuizSession();

    interface QuizSessionResponse {
        String getQuizSessionName();
    }

    CustomUserResponse getUser();

    interface CustomUserResponse {
        String getUsername();
        String getEmail();
        Long getId();
    }

    QuizResultResponse getQuiz();

    interface QuizResultResponse {
        Long getId();

        String getQuestionTitle();

        String getOptionOne();

        String getOptionTwo();

        String getOptionThree();

        String getOptionFour();

        String getQuestionAnswer();
    }
}
