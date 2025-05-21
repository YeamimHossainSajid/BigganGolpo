package com.example.BigganGlopo.features.subtopic.service;

import com.example.BigganGlopo.features.subtopic.entity.SubTopic;
import com.example.BigganGlopo.features.subtopic.payload.request.SubTopicRequestDto;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.service.IService;

public interface SubTopicService extends IService<SubTopic, SubTopicRequestDto, GenericSearchDto> {
}
