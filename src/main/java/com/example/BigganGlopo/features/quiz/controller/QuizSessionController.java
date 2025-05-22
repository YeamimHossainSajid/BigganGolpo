package com.example.BigganGlopo.features.quiz.controller;

import com.example.BigganGlopo.features.quiz.dto.request.QuizSessionRequestDto;
import com.example.BigganGlopo.features.quiz.dto.response.QuizSessionGetAllResponse;
import com.example.BigganGlopo.features.quiz.dto.response.QuizSessionResponseDto;
import com.example.BigganGlopo.features.quiz.service.QuizSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("QuizSession")
public class QuizSessionController {
    public QuizSessionService quizSessionService;

    @Autowired
    public QuizSessionController(QuizSessionService quizSessionService) {
        this.quizSessionService = quizSessionService;
    }

    //    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    @PostMapping(value = "/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> create(@ModelAttribute QuizSessionRequestDto quizSessionRequestDto) throws IOException {
        quizSessionService.CreateQuizSession(quizSessionRequestDto, quizSessionRequestDto.imageUrl());
        return ResponseEntity.ok("Quiz session created");
    }

    //    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> Delete(@PathVariable Long id) {
        quizSessionService.DeleteQuizSessionById(id);
        return ResponseEntity.ok("Quiz session deleted");
    }

    @GetMapping("quiz/{userId}/{id}")
    public ResponseEntity<QuizSessionResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(quizSessionService.GetQuizSessionById(id));
    }

    @GetMapping("quizSession/getAll")
    public ResponseEntity<List<QuizSessionGetAllResponse>> getAll() {
        return ResponseEntity.ok(quizSessionService.QuizSessionGetAll());
    }

    @GetMapping("searchBy/{name}")
    public ResponseEntity<List<QuizSessionGetAllResponse>> getBySessionName(@PathVariable String name) {
        return ResponseEntity.ok(quizSessionService.QuizSessionSearchByName(name));
    }

    @GetMapping("{sessionId}")
    public ResponseEntity<QuizSessionResponseDto> getByQuizSessionId(@PathVariable Long sessionId) {
        return ResponseEntity.ok(quizSessionService.GetQuizSessionById(sessionId));
    }

}
