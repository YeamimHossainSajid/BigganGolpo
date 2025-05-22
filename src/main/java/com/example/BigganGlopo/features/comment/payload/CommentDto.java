package com.example.BigganGlopo.features.comment.payload;

import com.example.BigganGlopo.features.vote.payload.request.ReactionDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentDto {
    private Long id;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private List<ReactionDto> reactions;
    private List<CommentDto> replies;
}
