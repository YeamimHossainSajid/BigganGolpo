package com.example.BigganGlopo.features.subtopic.service.impl;

import com.example.BigganGlopo.config.image.service.CloudneryImageService;
import com.example.BigganGlopo.features.subtopic.entity.SubTopic;
import com.example.BigganGlopo.features.subtopic.entity.SubTopicElement;
import com.example.BigganGlopo.features.subtopic.payload.request.SubTopicRequestDto;
import com.example.BigganGlopo.features.subtopic.payload.response.SubTopicElementDto;
import com.example.BigganGlopo.features.subtopic.payload.response.SubTopicResponseDto;
import com.example.BigganGlopo.features.subtopic.repository.SubTopicElementRepository;
import com.example.BigganGlopo.features.subtopic.repository.SubTopicRepository;
import com.example.BigganGlopo.features.subtopic.service.SubTopicService;
import com.example.BigganGlopo.features.topic.repository.TopicRepo;
import com.example.BigganGlopo.features.topic.service.TopicService;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.payload.response.BaseResponseDto;
import com.example.BigganGlopo.generic.repository.AbstractRepository;
import com.example.BigganGlopo.generic.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class SubTopicServiceImpl extends AbstractService<SubTopic, SubTopicRequestDto, GenericSearchDto> implements SubTopicService {

    @Autowired
    private SubTopicRepository subTopicRepository;
    @Autowired
    private SubTopicElementRepository elementRepository;
    @Autowired
    private CloudneryImageService cloudneryImageService;
    @Autowired
    private SubTopicElementRepository subTopicElementRepository;
    @Autowired
    private TopicRepo topicRepo;

    public SubTopicServiceImpl(AbstractRepository<SubTopic> repository) {
        super(repository);
    }

    @Override
    public SubTopicResponseDto convertToResponseDto(SubTopic subTopic) {
        List<SubTopicElementDto> elements = subTopicElementRepository
                .findBySubTopicOrderByOrderIndexAsc(subTopic)
                .stream()
                .map(e -> new SubTopicElementDto(e.getType(), e.getValue()))
                .toList();

        String topicName = subTopic.getTopic() != null ? subTopic.getTopic().getName() : null;

        return new SubTopicResponseDto(
                subTopic.getId(),
                subTopic.getTitle(),
                elements,
                topicName
        );
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


    public void uploadSubTopic(
            Long topicId,
            String title,
            List<String> elementTypes,
            List<String> textContents,
            List<MultipartFile> images
    ) throws IOException {

        SubTopic subTopic = new SubTopic();
        subTopic.setTitle(title);
        subTopic.setTopic(topicRepo.findById(topicId).get());
        subTopicRepository.save(subTopic);

        int textIndex = 0;
        int imageIndex = 0;

        for (int i = 0; i < elementTypes.size(); i++) {
            String type = elementTypes.get(i);
            SubTopicElement element = new SubTopicElement();
            element.setType(type);
            element.setOrderIndex(i + 1);
            element.setSubTopic(subTopic);

            if ("text".equals(type)) {
                element.setValue(textContents.get(textIndex++));
            } else if ("image".equals(type)) {
                MultipartFile image = images.get(imageIndex++);
                String imageUrl = uploadImage(image);
                element.setValue(imageUrl);
            }

            elementRepository.save(element);
        }
    }

    private String uploadImage(MultipartFile image) throws IOException {
        if (image == null || image.isEmpty()) return null;

        Map<String, Object> uploadResult = cloudneryImageService.upload(image);
        return (String) uploadResult.get("secure_url");
    }
    public List<SubTopicResponseDto> getSubTopicsByTopicName(String topicName) {
        List<SubTopic> subTopics = subTopicRepository.findByTopicNameContainingIgnoreCase(topicName);
        return subTopics.stream()
                .map(this::convertToResponseDto)
                .toList();
    }

}
