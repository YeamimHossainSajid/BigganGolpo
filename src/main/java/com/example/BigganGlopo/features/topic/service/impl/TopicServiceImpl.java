package com.example.BigganGlopo.features.topic.service.impl;

import com.example.BigganGlopo.config.image.service.CloudneryImageService;
import com.example.BigganGlopo.features.topic.entity.Topic;
import com.example.BigganGlopo.features.topic.payload.request.TopicRequestDto;
import com.example.BigganGlopo.features.topic.payload.response.TopicResponseDto;
import com.example.BigganGlopo.features.topic.repository.TopicRepo;
import com.example.BigganGlopo.features.topic.service.TopicService;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.payload.response.BaseResponseDto;
import com.example.BigganGlopo.generic.repository.AbstractRepository;
import com.example.BigganGlopo.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class TopicServiceImpl extends AbstractService<Topic, TopicRequestDto, GenericSearchDto> implements TopicService {

    @Autowired
    private CloudneryImageService cloudneryImageService;
    @Autowired
    private TopicRepo topicRepo;
    public TopicServiceImpl(AbstractRepository<Topic> repository) {
        super(repository);
    }

    @Override
    protected TopicResponseDto convertToResponseDto(Topic topic) {
        TopicResponseDto topicResponseDto = new TopicResponseDto();
        topicResponseDto.setName(topic.getName());
        topicResponseDto.setUrl(topic.getUrl());
        return topicResponseDto ;
    }

    @Override
    protected Topic convertToEntity(TopicRequestDto topicRequestDto) throws IOException {
        return updateEntity(topicRequestDto,new Topic());
    }

    @Override
    protected Topic updateEntity(TopicRequestDto topicRequestDto, Topic entity) throws IOException {
    return null;
    }

    @Override
    protected Specification<Topic> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }

    public void createV2(TopicRequestDto topicRequestDto, MultipartFile image) throws IOException {
       Topic entity = new Topic();
        if (image != null && !image.isEmpty()) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(image);
          String profileImageUrl = (String) uploadResult.get("secure_url");
            entity.setUrl(profileImageUrl);
        }
        entity.setName(topicRequestDto.getName());

        topicRepo.save(entity);
    }
}

