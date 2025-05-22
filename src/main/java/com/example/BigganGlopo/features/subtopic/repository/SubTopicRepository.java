package com.example.BigganGlopo.features.subtopic.repository;

import com.example.BigganGlopo.features.subtopic.entity.SubTopic;
import com.example.BigganGlopo.generic.repository.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubTopicRepository extends AbstractRepository<SubTopic> {
    @Query("SELECT s FROM SubTopic s WHERE LOWER(s.topic.name) LIKE LOWER(CONCAT('%', :topicName, '%'))")
    List<SubTopic> findByTopicNameContainingIgnoreCase(@Param("topicName") String topicName);
}
