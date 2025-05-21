package com.example.BigganGlopo.features.topic.service.impl;

import com.example.BigganGlopo.features.topic.entity.Topic;
import com.example.BigganGlopo.features.topic.payload.request.TopicRequestDto;
import com.example.BigganGlopo.features.topic.service.TopicService;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.payload.response.BaseResponseDto;
import com.example.BigganGlopo.generic.repository.AbstractRepository;
import com.example.BigganGlopo.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;

public class TopicServiceImpl extends AbstractService<Topic, TopicRequestDto, GenericSearchDto> implements TopicService {
    public TopicServiceImpl(AbstractRepository<Topic> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(Topic topic) {
        return null;
    }

    @Override
    protected Topic convertToEntity(TopicRequestDto topicRequestDto) throws IOException {
        return null;
    }

    @Override
    protected Topic updateEntity(TopicRequestDto topicRequestDto, Topic entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Topic> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
