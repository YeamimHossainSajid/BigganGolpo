package com.example.BigganGlopo.features.subtopic.service.impl;

import com.example.BigganGlopo.features.subtopic.entity.SubTopic;
import com.example.BigganGlopo.features.subtopic.payload.request.SubTopicRequestDto;
import com.example.BigganGlopo.features.subtopic.service.SubTopicService;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.payload.response.BaseResponseDto;
import com.example.BigganGlopo.generic.repository.AbstractRepository;
import com.example.BigganGlopo.generic.service.AbstractService;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;

public class SubTopicServiceImpl extends AbstractService<SubTopic, SubTopicRequestDto, GenericSearchDto> implements SubTopicService {
    public SubTopicServiceImpl(AbstractRepository<SubTopic> repository) {
        super(repository);
    }

    @Override
    protected <T extends BaseResponseDto> T convertToResponseDto(SubTopic subTopic) {
        return null;
    }

    @Override
    protected SubTopic convertToEntity(SubTopicRequestDto subTopicRequestDto) throws IOException {
        return null;
    }

    @Override
    protected SubTopic updateEntity(SubTopicRequestDto subTopicRequestDto, SubTopic entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<SubTopic> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }
}
