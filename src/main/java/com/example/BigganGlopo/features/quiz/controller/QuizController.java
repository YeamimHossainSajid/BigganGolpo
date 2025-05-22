package com.example.BigganGlopo.features.quiz.controller;

import com.example.BigganGlopo.features.quiz.dto.request.QuizRequestDto;
import com.example.BigganGlopo.features.quiz.dto.response.QuizResponseDto;
import com.example.BigganGlopo.features.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


//    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @PostMapping("Create")
    public ResponseEntity<String> createQuiz(QuizRequestDto quizRequestDto) {
        quizService.createQuiz(quizRequestDto);
        return ResponseEntity.ok("Quiz created");
    }

//    @GetMapping("Get-All")
//    public ResponseEntity<PageResponseDto>getQuizList(
//            @RequestParam(value = "pageNo",
//            defaultValue = "1",
//            required = false)
//
//             int pageNo
//            ,@RequestParam(
//            value = "pageSize",
//            defaultValue = "10",
//            required = false
//    ) int pageSize) {
//        return ResponseEntity.ok(quizService.getAllQuiz(pageNo, pageSize));
//    }

//    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteQuiz(@PathVariable  Long id) {
        quizService.DeleteQuiz(id);
        return ResponseEntity.ok("Quiz deleted");
    }

    @GetMapping("quizSession/{quizSessionId}")
    public ResponseEntity<List<QuizResponseDto>>getAllByQuizSessionId(@PathVariable Long quizSessionId) {
        return ResponseEntity.ok(quizService.findAllQuizByQuizSessionId(quizSessionId));
    }

}
