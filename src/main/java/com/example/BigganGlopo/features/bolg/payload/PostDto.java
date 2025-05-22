package com.example.BigganGlopo.features.bolg.payload;

import com.example.BigganGlopo.features.comment.payload.CommentDto;
import com.example.BigganGlopo.features.vote.payload.request.ReactionDto;
import com.example.BigganGlopo.generic.payload.request.IDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostDto {
    private Long id;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private List<ReactionDto> reactions;
    private List<CommentDto> comments;
}