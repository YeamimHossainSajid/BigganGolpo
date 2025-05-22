package com.example.BigganGlopo.features.quiz.service.impl;

import com.example.BigganGlopo.auth.repository.UserRepo;
import com.example.BigganGlopo.features.quiz.dto.response.QuizResultResponseDto;
import com.example.BigganGlopo.features.quiz.dto.response.UserCorrectAnswerResponse;
import com.example.BigganGlopo.features.quiz.model.quiz.Quiz;
import com.example.BigganGlopo.features.quiz.model.quizresult.QuizResult;
import com.example.BigganGlopo.features.quiz.repository.quizRepo.QuizRepo;
import com.example.BigganGlopo.features.quiz.repository.quizSessionRepo.QuizSessionRepo;
import com.example.BigganGlopo.features.quiz.repository.quizresultrepo.QuizResultRepo;
import com.example.BigganGlopo.features.quiz.service.QuizResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizResultServiceImpl implements QuizResultService {

    private final QuizResultRepo quizResultRepository;
    private final QuizRepo quizRepo;
    private final UserRepo userRepo;
    private final QuizSessionRepo quizSessionRepo;

//    @Autowired
//    public QuizResultServiceImpl(QuizResultRepo quizResultRepository,QuizRepo quizRepo) {
//        this.quizResultRepository = quizResultRepository;
//        this.quizRepo = quizRepo;
//    }

    @Transactional
    public void submitAnswer(Long userId, Long quizSessionId, Long questionId, String userAnswer) {
        boolean isCorrect = checkAnswer(questionId, userAnswer);

        QuizResult quizResult = new QuizResult();
        quizResult.setUser(userRepo.findById(userId).orElse(null));
        quizResult.setQuizSession(quizSessionRepo.findById(quizSessionId).orElse(null));
        quizResult.setQuiz(quizRepo.findById(questionId).orElse(null));
        quizResult.setIsCorrect(isCorrect);
        quizResult.setTime(LocalDateTime.now());
        quizResult.setUserAnswer(userAnswer);

        quizResultRepository.save(quizResult);
    }


    public List<UserCorrectAnswerResponse> getCorrectAnswersBySession(Long sessionId) {
        List<Object[]> results = quizResultRepository.findCorrectAnswerCountsGroupedByUserAndSession(sessionId);

        return results.stream()
                .map(result -> new UserCorrectAnswerResponse(
                        (Long) result[0], // userId
                        (String) result[1] ,
                        (Long) result[2] // correct count
                ))
                .toList();
    }

    private boolean checkAnswer(Long questionId, String userAnswer) {
        String correctAnswer = getCorrectAnswerFromDB(questionId);
        return userAnswer.equals(correctAnswer);
    }

    private String getCorrectAnswerFromDB(Long questionId) {
       Quiz quiz= quizRepo.findById(questionId).get();
        return quiz.getQuestionAnswer();
    }

    public List<QuizResultResponseDto> getCorrectAnswerById(Long quizSessionId, Long userId) {
        List<QuizResultResponseDto>quizResultResponseDto=   quizResultRepository.QuizSessionIdAndUserIdAndIsCorrect(quizSessionId, userId);
   if(quizResultResponseDto.isEmpty()){
       throw new RuntimeException("user havent give any answers");
   }else {
       return quizResultResponseDto;
   }

    }
}
