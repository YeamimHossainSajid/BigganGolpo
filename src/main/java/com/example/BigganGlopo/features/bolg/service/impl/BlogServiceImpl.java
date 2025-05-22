package com.example.BigganGlopo.features.bolg.service.impl;

import com.example.BigganGlopo.auth.model.User;
import com.example.BigganGlopo.auth.repository.UserRepo;
import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.features.bolg.payload.PostDto;
import com.example.BigganGlopo.features.bolg.repository.BlogRepository;
import com.example.BigganGlopo.features.comment.entity.Comment;
import com.example.BigganGlopo.features.comment.payload.CommentDto;
import com.example.BigganGlopo.features.comment.repository.CommentRepository;
import com.example.BigganGlopo.features.vote.entity.Vote;
import com.example.BigganGlopo.features.vote.payload.request.ReactionDto;
import com.example.BigganGlopo.features.vote.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl {
    private final BlogRepository postRepository;
    private final CommentRepository commentRepository;
    private final ReactionRepository reactionRepository;

    @Autowired
    UserRepo userRepo;

    public BlogServiceImpl(BlogRepository postRepository,
                           CommentRepository commentRepository,
                           ReactionRepository reactionRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.reactionRepository = reactionRepository;
    }

    public List<PostDto> getAllPostsWithDetails() {
        List<Blog> posts = postRepository.findAllByOrderByCreatedAtDesc();
        return posts.stream()
                .map(this::mapToPostDto)
                .collect(Collectors.toList());
    }

    private PostDto mapToPostDto(Blog post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setContent(post.getContent());
        dto.setUsername(post.getUser().getUsername());
        dto.setCreatedAt(post.getCreatedAt());

        List<ReactionDto> postReactions = reactionRepository.findByPostId(post.getId())
                .stream().map(this::mapToReactionDto).toList();
        dto.setReactions(postReactions);

        List<CommentDto> commentDtos = commentRepository.findByPostId(post.getId()).stream()
                .filter(c -> c.getParentComment() == null)
                .map(this::mapToCommentDto)
                .collect(Collectors.toList());
        dto.setComments(commentDtos);

        return dto;
    }

    private CommentDto mapToCommentDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setUsername(comment.getUser().getUsername());
        dto.setCreatedAt(comment.getCreatedAt());

        List<ReactionDto> commentReactions = reactionRepository.findByCommentId(comment.getId())
                .stream().map(this::mapToReactionDto).toList();
        dto.setReactions(commentReactions);

        List<CommentDto> replies = commentRepository.findByParentCommentId(comment.getId()).stream()
                .map(this::mapToCommentDto)
                .collect(Collectors.toList());
        dto.setReplies(replies);

        return dto;
    }

    private ReactionDto mapToReactionDto(Vote reaction) {
        ReactionDto dto = new ReactionDto();
        dto.setId(reaction.getId());
        dto.setType(reaction.getType());
        dto.setUsername(reaction.getUser().getUsername());
        return dto;
    }

    public Blog createPost(Long userId, String content) {
        User user = userRepo.findById(userId).orElseThrow();
        Blog post = new Blog();
        post.setUser(user);
        post.setContent(content);
        return postRepository.save(post);
    }

    public List<Blog> getAllPostsSortedByTime() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }
}
