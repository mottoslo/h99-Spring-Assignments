package com.sparta.spring_assignment_lv4.controller;


import com.sparta.spring_assignment_lv4.dto.*;
import com.sparta.spring_assignment_lv4.entity.User;
import com.sparta.spring_assignment_lv4.service.ArticleService;
import com.sparta.spring_assignment_lv4.service.CommentService;
import com.sparta.spring_assignment_lv4.utils.springSecurity.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;

    @GetMapping
    public List<ArticleListResponseDto> getArticleList(){
        return articleService.getArticleList();
    }

    @PostMapping
    public ArticleDetailResponseDto postArticle(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody ArticlePostRequestDto requestDto
    ){
        return articleService.postArticle(userDetails.getUser(), requestDto);
    }

    @GetMapping("/{articleId}")
    public ArticleDetailResponseDto getArticleById(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long articleId
    ){
        User user = userDetails.getUser();
        return articleService.getArticleById(user, articleId);
    }

    @GetMapping("/{articleId}/{rootCommentId}") // 대댓글 가져오기
    public List<CommentResponseDto> getCommentsOnComment(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long articleId,
            @PathVariable Long rootCommentId
    ){
        User user = userDetails.getUser();
        return commentService.getCommentsOnComment(user, articleId, rootCommentId);
    }

    @PutMapping("/{articleId}")
    public ArticleDetailResponseDto editArticle(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long articleId,
            @RequestBody ArticleEditRequestDto requestDto
    ){
        User user = userDetails.getUser();
        return articleService.editArticle(user, articleId, requestDto);
    }

    @DeleteMapping("/{articleId}")
    public void deleteArticle(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long articleId
    ){
        User user = userDetails.getUser();
        articleService.deleteArticle(user, articleId);
    }

    @PostMapping("/like/{articleId}")
    public void likeArticle(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long articleId
    ){
        Long userId = userDetails.getUser().getId();
        articleService.likeArticle(userId, articleId);
    }

    @DeleteMapping("like/{articleId}")
    public void likeCancelArticle(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long articleId
    ){
        Long userId = userDetails.getUser().getId();
        articleService.likeCancelArticle(userId, articleId);
    }



}
