package com.example.BigganGlopo.features.bolg.service.impl;

import com.example.BigganGlopo.config.image.service.CloudneryImageService;
import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.features.bolg.payload.BlogRequestDto;
import com.example.BigganGlopo.features.bolg.payload.BlogResponseDto;
import com.example.BigganGlopo.features.bolg.repository.BlogRepository;
import com.example.BigganGlopo.features.bolg.service.BlogService;
import com.example.BigganGlopo.features.topic.entity.Topic;
import com.example.BigganGlopo.features.topic.payload.request.TopicRequestDto;
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
public  class BlogServiceImpl extends AbstractService<Blog, BlogRequestDto, GenericSearchDto> implements BlogService {
    @Autowired
    BlogRepository repository;
    @Autowired
    CloudneryImageService cloudneryImageService;
    public BlogServiceImpl(AbstractRepository<Blog> repository) {
        super(repository);
    }

    @Override
    protected BlogResponseDto convertToResponseDto(Blog blog) {
        BlogResponseDto responseDto = new BlogResponseDto();
        responseDto.setDescription(blog.getDescription());
        responseDto.setUrl(blog.getUrl());
        return responseDto;
    }

    @Override
    protected Blog convertToEntity(BlogRequestDto blogRequestDto) throws IOException {
        return null;
    }

    @Override
    protected Blog updateEntity(BlogRequestDto blogRequestDto, Blog entity) throws IOException {
        return null;
    }

    @Override
    protected Specification<Blog> buildSpecification(GenericSearchDto searchDto) {
        return null;
    }

    public void createV2(BlogRequestDto requestDto, MultipartFile image) throws IOException {
        Blog entity = new Blog();
        if (image != null && !image.isEmpty()) {
            Map<String, Object> uploadResult = cloudneryImageService.upload(image);
            String profileImageUrl = (String) uploadResult.get("secure_url");
            entity.setUrl(profileImageUrl);
        }
        entity.setDescription(requestDto.getDescription());

        repository.save(entity);
    }
}
