package com.example.BigganGlopo.features.quiz.service;
import com.example.BigganGlopo.features.quiz.dto.request.QuizSessionRequestDto;
import com.example.BigganGlopo.features.quiz.dto.response.QuizSessionGetAllResponse;
import com.example.BigganGlopo.features.quiz.dto.response.QuizSessionResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface QuizSessionService {

    void CreateQuizSession(QuizSessionRequestDto quizSessionRequestDto, MultipartFile heroImageFile)throws IOException;

    QuizSessionResponseDto GetQuizSessionById(Long quizSessionId);

    void DeleteQuizSessionById(Long quizSessionId);

    List<QuizSessionGetAllResponse> QuizSessionGetAll();

    List<QuizSessionGetAllResponse> QuizSessionSearchByName(String name);
}
