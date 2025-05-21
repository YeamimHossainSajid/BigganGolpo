package com.example.BigganGlopo.features.subtopic.repository;

import com.example.BigganGlopo.features.subtopic.entity.SubTopic;
import com.example.BigganGlopo.features.subtopic.entity.SubTopicElement;
import com.example.BigganGlopo.generic.repository.AbstractRepository;

import java.util.List;

public interface SubTopicElementRepository extends AbstractRepository<SubTopicElement> {
    List<SubTopicElement> findBySubTopicOrderByOrderIndexAsc(SubTopic subTopic);
}
