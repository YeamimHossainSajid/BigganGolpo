package com.example.BigganGlopo.features.topic.controller;

import com.example.BigganGlopo.features.topic.entity.Topic;
import com.example.BigganGlopo.features.topic.payload.request.TopicRequestDto;
import com.example.BigganGlopo.features.topic.service.TopicService;
import com.example.BigganGlopo.generic.controller.AbstractController;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.service.IService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/topic")
public class TopicController extends AbstractController<Topic, TopicRequestDto, GenericSearchDto> {
    private TopicService topicService;
    public TopicController(IService<Topic, TopicRequestDto, GenericSearchDto> service,TopicService topicService) {
        super(service);
        this.topicService = topicService;
    }

    @PostMapping(value = "/add/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> create(@ModelAttribute TopicRequestDto dto) throws IOException {
        MultipartFile image=dto.getUrl();
        topicService.createV2(dto,image);
        return ResponseEntity.ok("Student created");
    }
}
