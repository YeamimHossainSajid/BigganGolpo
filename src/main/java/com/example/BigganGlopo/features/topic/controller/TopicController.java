package com.example.BigganGlopo.features.topic.controller;

import com.example.BigganGlopo.features.topic.entity.Topic;
import com.example.BigganGlopo.features.topic.payload.request.TopicRequestDto;
import com.example.BigganGlopo.generic.controller.AbstractController;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.service.IService;

public class TopicController extends AbstractController<Topic, TopicRequestDto, GenericSearchDto> {
    public TopicController(IService<Topic, TopicRequestDto, GenericSearchDto> service) {
        super(service);
    }
}
