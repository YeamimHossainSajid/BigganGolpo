package com.example.BigganGlopo.features.subtopic.service;

import com.example.BigganGlopo.features.subtopic.entity.SubTopic;
import com.example.BigganGlopo.features.subtopic.payload.request.SubTopicRequestDto;
import com.example.BigganGlopo.features.subtopic.payload.response.SubTopicResponseDto;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SubTopicService extends IService<SubTopic, SubTopicRequestDto, GenericSearchDto> {

    public void uploadSubTopic(Long topicId,String title, List<String> elementTypes, List<String>textContents, List<MultipartFile> images) throws IOException;
    public List<SubTopicResponseDto> getSubTopicsByTopicName(String topicName);
}
