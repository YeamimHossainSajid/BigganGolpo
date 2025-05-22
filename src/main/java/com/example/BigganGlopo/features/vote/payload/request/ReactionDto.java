package com.example.BigganGlopo.features.vote.payload.request;

import lombok.Data;

@Data
public class ReactionDto {
    private Long id;
    private String type;
    private String username;
}
