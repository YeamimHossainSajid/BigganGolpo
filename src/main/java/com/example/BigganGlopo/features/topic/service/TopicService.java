package com.example.BigganGlopo.features.topic.service;

import com.example.BigganGlopo.features.topic.entity.Topic;
import com.example.BigganGlopo.features.topic.payload.request.TopicRequestDto;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TopicService extends IService<Topic, TopicRequestDto, GenericSearchDto> {
    public void createV2(TopicRequestDto topicRequestDto, MultipartFile image) throws IOException;
}
