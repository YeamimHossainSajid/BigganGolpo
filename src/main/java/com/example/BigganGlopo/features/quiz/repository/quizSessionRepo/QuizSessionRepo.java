package com.example.BigganGlopo.features.quiz.repository.quizSessionRepo;

import com.example.BigganGlopo.features.quiz.dto.response.QuizSessionGetAllResponse;
import com.example.BigganGlopo.features.quiz.dto.response.QuizSessionResponseDto;
import com.example.BigganGlopo.features.quiz.model.quizsession.QuizSession;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizSessionRepo extends JpaRepository<QuizSession, Long> {
    @EntityGraph( attributePaths = { "quizzes" } )
    @Query( """
                SELECT
                    q
                FROM
                   QuizSession q
                WHERE
                    q.id = :id
            """ )
    QuizSessionResponseDto findQuizSessionById(@Param( "id" ) Long id );

    @Query("""
            Select q from QuizSession q ORDER BY q.id DESC
            """)
    List<QuizSessionGetAllResponse> quizSessionGetAll();


    @Query("""
   SELECT q 
   FROM QuizSession q 
   WHERE LOWER(q.QuizSessionName) LIKE LOWER(CONCAT('%', :name, '%'))
   """)
    List<QuizSessionGetAllResponse> findQuizSessionByName(@Param("name") String name);

}
