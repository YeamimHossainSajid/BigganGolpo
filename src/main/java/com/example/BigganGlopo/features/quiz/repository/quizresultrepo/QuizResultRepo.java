package com.example.BigganGlopo.features.quiz.repository.quizresultrepo;
import com.example.BigganGlopo.features.quiz.dto.response.QuizResultResponseDto;
import com.example.BigganGlopo.features.quiz.model.quizresult.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizResultRepo  extends JpaRepository<QuizResult, Long> {

    @Query("SELECT q.user.id,q.user.username, COUNT(q) " +
            "FROM QuizResult q " +
            "WHERE q.quizSession.id = :quizSessionId AND q.isCorrect = true " +
            "GROUP BY q.user.id,q.user.username " +
            "ORDER BY COUNT(q) DESC")
    List<Object[]> findCorrectAnswerCountsGroupedByUserAndSession(@Param("quizSessionId") Long quizSessionId);

    @Query("SELECT  q FROM QuizResult q WHERE q.quizSession.id = :quizSessionId AND q.user.id= :userId ")
    List<QuizResultResponseDto> QuizSessionIdAndUserIdAndIsCorrect(@Param("quizSessionId") Long quizSessionId, @Param("userId") Long userId);
}
