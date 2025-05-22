package com.example.BigganGlopo.features.quiz.model.quizresult;
import com.example.BigganGlopo.auth.model.User;
import com.example.BigganGlopo.features.quiz.model.quiz.Quiz;
import com.example.BigganGlopo.features.quiz.model.quizsession.QuizSession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class QuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_session_id", referencedColumnName = "id", nullable = false)
    private QuizSession quizSession;

    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id", nullable = false)
    private Quiz quiz;

    @Column(nullable = false)
    private Boolean isCorrect;

    @Column(nullable = false)
    private LocalDateTime time;

    private String userAnswer;
}

