package com.sparta.spring_assignment_lv4.dto;

import com.sparta.spring_assignment_lv4.entity.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Getter
public class ArticleDetailResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private List<CommentResponseDto> comments;

    public ArticleDetailResponseDto(Article article, List<CommentResponseDto> comments) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.userId = article.getUser().getUserId();
        this.createdAt = article.getCreatedAt();
        this.modifiedAt = article.getModifiedAt();
    }
}
