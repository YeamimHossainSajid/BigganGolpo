package com.example.BigganGlopo.features.bolg.controller;

import com.example.BigganGlopo.features.bolg.entity.Blog;
import com.example.BigganGlopo.features.bolg.payload.PostDto;
import com.example.BigganGlopo.features.bolg.service.impl.BlogServiceImpl;
import com.example.BigganGlopo.features.comment.entity.Comment;
import com.example.BigganGlopo.features.comment.service.CommentService;
import com.example.BigganGlopo.features.comment.service.impl.CommentServiceImpl;
import com.example.BigganGlopo.features.vote.service.impl.VoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogController {
    @Autowired
    private BlogServiceImpl postService;
    @Autowired private CommentServiceImpl commentService;
    @Autowired private VoteServiceImpl reactionService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> createPost(@PathVariable Long userId, @RequestBody String content) {
         postService.createPost(userId, content);
         return ResponseEntity.ok("Post created");

    }

    @PostMapping("/{postId}/react")
    public ResponseEntity<String> reactToPost(@PathVariable Long postId, @RequestParam Long userId, @RequestParam String type) {
         reactionService.togglePostReaction(postId, userId, type);
         return ResponseEntity.ok("Post reacted");
    }

    @PostMapping("/{postId}/comment")
    public ResponseEntity<String> commentOnPost(@PathVariable Long postId, @RequestParam Long userId,
                                 @RequestBody String content, @RequestParam(required = false) Long parentCommentId) {
         commentService.addComment(postId, userId, content, parentCommentId);
         return ResponseEntity.ok("Comment added");
    }

    @PostMapping("/comments/{commentId}/react")
    public ResponseEntity<String> reactToComment(@PathVariable Long commentId, @RequestParam Long userId, @RequestParam String type) {
         reactionService.toggleCommentReaction(commentId, userId, type);
         return ResponseEntity.ok("Comment reacted");
    }
    @GetMapping("/recent")
    public ResponseEntity<List<PostDto>> getRecentPosts() {
        List<PostDto> posts = postService.getAllPostsWithDetails();
        return ResponseEntity.ok(posts);
    }
    @GetMapping("/user/{userId}")
    public List<PostDto> getBlogsByUserId(@PathVariable Long userId) {
        return postService.searchBlogByUserId(userId);
    }

}
