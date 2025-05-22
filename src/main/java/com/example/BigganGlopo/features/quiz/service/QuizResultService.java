package com.example.BigganGlopo.features.quiz.service;

import com.example.BigganGlopo.features.quiz.dto.response.QuizResultResponseDto;
import com.example.BigganGlopo.features.quiz.dto.response.UserCorrectAnswerResponse;

import java.util.List;

public interface QuizResultService {
    public void submitAnswer(Long userId, Long quizSessionId, Long questionId, String userAnswer);
    public List<UserCorrectAnswerResponse> getCorrectAnswersBySession(Long sessionId);

   List<QuizResultResponseDto> getCorrectAnswerById(Long quizSessionId, Long userId);
}
