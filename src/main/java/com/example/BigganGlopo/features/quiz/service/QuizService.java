package com.example.BigganGlopo.features.quiz.service;

import com.example.BigganGlopo.features.quiz.dto.request.QuizRequestDto;
import com.example.BigganGlopo.features.quiz.dto.response.QuizResponseDto;

import java.util.List;

public interface QuizService {

    void createQuiz(QuizRequestDto quizRequestDto);

    void DeleteQuiz(Long id);

    List<QuizResponseDto> findAllQuizByQuizSessionId(Long quizSessionId);

}
