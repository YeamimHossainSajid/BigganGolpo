package com.example.BigganGlopo.features.quiz.repository.quizRepo;
import com.example.BigganGlopo.features.quiz.dto.response.QuizResponseDto;
import com.example.BigganGlopo.features.quiz.model.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {

    @Query("SELECT q FROM Quiz q WHERE q.quizSession.id = :quizSessionId")
    List<QuizResponseDto> findAllQuizByQuizSessionId(@Param("quizSessionId") Long quizSessionId);

}
