package com.example.BigganGlopo.features.bolg.service;

import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.features.bolg.payload.BlogRequestDto;
import com.example.BigganGlopo.generic.payload.request.GenericSearchDto;
import com.example.BigganGlopo.generic.service.IService;

public interface BlogService extends IService<Blog, BlogRequestDto, GenericSearchDto> {
}
