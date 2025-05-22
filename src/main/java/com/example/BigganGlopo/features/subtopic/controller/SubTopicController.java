package com.example.BigganGlopo.features.subtopic.controller;

import com.example.BigganGlopo.features.subtopic.entity.SubTopic;
import com.example.BigganGlopo.features.subtopic.payload.request.SubTopicRequestDto;
import com.example.BigganGlopo.features.subtopic.payload.response.SubTopicResponseDto;
import com.example.BigganGlopo.features.subtopic.service.SubTopicService;
import com.example.BigganGlopo.generic.controller.AbstractController;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/subtopic")
public class SubTopicController extends AbstractController<SubTopic, SubTopicRequestDto, GenericSearchDto> {

    @Autowired
      SubTopicService subTopicService;

    public SubTopicController(IService<SubTopic, SubTopicRequestDto, GenericSearchDto> service) {
        super(service);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadSubTopic(
             @RequestParam Long topicId,
            @RequestParam String title,
            @RequestParam("elementTypes") List<String> elementTypes,
            @RequestParam("textContents") List<String> textContents,
            @RequestParam("images") List<MultipartFile> images
    ) throws IOException {
        subTopicService.uploadSubTopic(topicId,title, elementTypes, textContents, images);
        return ResponseEntity.ok("SubTopic uploaded successfully.");
    }

    @GetMapping("/search-by-topic")
    public ResponseEntity<List<SubTopicResponseDto>> getSubTopicsByTopicName(@RequestParam String topicName) {
        List<SubTopicResponseDto> result = subTopicService.getSubTopicsByTopicName(topicName);
        return ResponseEntity.ok(result);
    }
}
