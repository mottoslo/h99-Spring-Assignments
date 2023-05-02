package com.sparta.spring_assignment_lv4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Long rootArticleId;

    @Column
    private Long rootCommentId;

    @Column
    private Boolean isDeleted = false;

    @Column
    private Integer numLikes = 0;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Comment(String content, User user, Long rootArticleId) {
        this.content = content;
        this.user = user;
        this.rootArticleId = rootArticleId;
    }

    public Comment(String content, User user, Long rootArticleId, Long rootCommentId) {
        this.content = content;
        this.user = user;
        this.rootArticleId = rootArticleId;
        this.rootCommentId = rootCommentId;
    }

    public void updateContent(String content){ this.content = content; }

    public void flagDeleted(){ this.isDeleted = true; }

    public void addLike() { this.numLikes++; }

    public void cancelLike() { this.numLikes--; }
}
