package com.example.BigganGlopo.features.quiz.service.impl;

import com.example.BigganGlopo.features.quiz.dto.request.QuizRequestDto;
import com.example.BigganGlopo.features.quiz.dto.response.QuizResponseDto;
import com.example.BigganGlopo.features.quiz.model.quiz.Quiz;
import com.example.BigganGlopo.features.quiz.repository.quizRepo.QuizRepo;
import com.example.BigganGlopo.features.quiz.repository.quizSessionRepo.QuizSessionRepo;
import com.example.BigganGlopo.features.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    public QuizRepo quizRepo;
    public QuizSessionRepo quizSessionRepo;


    @Autowired
    public QuizServiceImpl(QuizRepo quizRepo, QuizSessionRepo quizSessionRepo) {
        this.quizRepo = quizRepo;
        this.quizSessionRepo = quizSessionRepo;
    }

    public Quiz ConvertToEntity(QuizRequestDto quizRequestDto, Quiz quiz) {
       // quiz.setId(quizRequestDto.id());
        quiz.setQuizSession(quizSessionRepo.findById(quizRequestDto.quizSessionId()).orElse(null));
        quiz.setQuestionAnswer(quizRequestDto.questionAnswer());
        quiz.setQuestionTitle(quizRequestDto.questionTitle());
        quiz.setOptionOne(quizRequestDto.optionOne());
        quiz.setOptionTwo(quizRequestDto.optionTwo());
        quiz.setOptionThree(quizRequestDto.optionThree());
        quiz.setOptionFour(quizRequestDto.optionFour());
        return quiz;
    }

    private QuizRequestDto mapToDto(Quiz quiz) {
//         QuizRequestDto quizRequestDto = new QuizRequestDto(
//                 quiz.getId(),
//                 quiz.getQuestionTitle(),
//                 quiz.getQuestionAnswer(),
//                 quiz.getOptionOne(),
//                 quiz.getOptionTwo(),
//                 quiz.getOptionThree(),
//                 quiz.getOptionFour(),
//                 quizRequestDto.quizSessionId() );
      //  QuizSession quizSession=quizSessionRepo.findById(quizRequestDto.quizSessionId()).orElse(null);
        return new QuizRequestDto(
                quiz.getQuestionTitle()
                , quiz.getQuestionAnswer(),
                quiz.getOptionOne(),
                quiz.getOptionTwo(),
                quiz.getOptionThree()
                , quiz.getOptionFour(),
                quiz.getQuizSession() == null ? null:quiz.getQuizSession().getId()
        );
    }

    @Override
    public void createQuiz(QuizRequestDto quizRequestDto) {
        Quiz quiz1 = ConvertToEntity(quizRequestDto, new Quiz());
        quizRepo.save(quiz1);
    }

//    @Override
//    public PageResponseDto getAllQuiz(int pageNo, int pageSize) {
//        Pageable pageable= PageRequest.of(pageNo-1, pageSize);
//        Page<Quiz> quizPage = quizRepo.findAllWithPaginationOrdered(pageable);
//        List<QuizRequestDto> quizRequestDtoList = quizPage.getContent().stream()
//                .map(this::mapToDto)
//                .collect(Collectors.toList());
//        PageResponseDto pageResponseDto = new PageResponseDto();
//        pageResponseDto.setContent(quizRequestDtoList);
//        pageResponseDto.setPageSize(quizPage.getSize());
//        pageResponseDto.setPageNo(quizPage.getNumber());
//        pageResponseDto.setTotalElements(quizPage.getTotalElements());
//        pageResponseDto.setTotalPages(quizPage.getTotalPages());
//        pageResponseDto.setLast(quizPage.isLast());
//        return pageResponseDto;
//    }

    @Override
    public void DeleteQuiz(Long id) {
        quizRepo.deleteById(id);
    }

    public List<QuizResponseDto>findAllQuizByQuizSessionId(Long quizSessionId) {
        return quizRepo.findAllQuizByQuizSessionId(quizSessionId);
    }


}
