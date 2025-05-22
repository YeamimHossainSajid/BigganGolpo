package com.example.BigganGlopo.features.quiz.service.impl;

import com.example.BigganGlopo.config.image.service.impl.CloudneryImageServiceImpl;
import com.example.BigganGlopo.features.quiz.dto.request.QuizSessionRequestDto;
import com.example.BigganGlopo.features.quiz.dto.response.QuizSessionGetAllResponse;
import com.example.BigganGlopo.features.quiz.dto.response.QuizSessionResponseDto;
import com.example.BigganGlopo.features.quiz.model.quizsession.QuizSession;
import com.example.BigganGlopo.features.quiz.repository.quizSessionRepo.QuizSessionRepo;
import com.example.BigganGlopo.features.quiz.service.QuizSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Service
public class QuizSessionServiceImpl implements QuizSessionService {

   public QuizSessionRepo quizSessionRepo;
    public CloudneryImageServiceImpl cloudneryImageService;

    @Autowired
    public QuizSessionServiceImpl(QuizSessionRepo quizSessionRepo, CloudneryImageServiceImpl cloudneryImageService) {
        this.quizSessionRepo = quizSessionRepo;
        this.cloudneryImageService = cloudneryImageService;
    }


    @Override
    public void CreateQuizSession(QuizSessionRequestDto quizSessionRequestDto, MultipartFile heroImageFile) throws IOException {
        QuizSession quizSession = new QuizSession();
        Map<String, Object> heroUploadResult = cloudneryImageService.upload(heroImageFile);
        String heroImageUrl = (String) heroUploadResult.get("secure_url");

        quizSession.setQuizSessionName(quizSessionRequestDto.QuizSessionName());
        quizSession.setImageUrl(heroImageUrl);
        quizSessionRepo.save(quizSession);
    }

    @Override
    public QuizSessionResponseDto GetQuizSessionById(Long quizSessionId) {
        QuizSessionResponseDto singleQuizSessionById = quizSessionRepo.findQuizSessionById(quizSessionId);
        if (Objects.isNull( singleQuizSessionById ) ) {
            throw new RuntimeException("not found" );
        }
        return singleQuizSessionById;
    }

    @Override
    public void DeleteQuizSessionById(Long quizSessionId) {
      quizSessionRepo.deleteById(quizSessionId);
    }

    @Override
    public List<QuizSessionGetAllResponse> QuizSessionGetAll() {
        return quizSessionRepo.quizSessionGetAll() ;
    }

    @Override
    public List<QuizSessionGetAllResponse> QuizSessionSearchByName(String name) {
        return quizSessionRepo.findQuizSessionByName(name );
    }
}
