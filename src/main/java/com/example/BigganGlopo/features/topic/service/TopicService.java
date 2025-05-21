package com.example.BigganGlopo.features.topic.service;

import com.example.BigganGlopo.features.topic.entity.Topic;
import com.example.BigganGlopo.features.topic.payload.request.TopicRequestDto;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.service.IService;

public interface TopicService extends IService<Topic, TopicRequestDto, GenericSearchDto> {
}
