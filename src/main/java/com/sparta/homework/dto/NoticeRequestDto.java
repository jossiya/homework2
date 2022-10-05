package com.sparta.homework.dto;

import com.sparta.homework.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class NoticeRequestDto {

    private String title;
    private String writer;
    private  String content;
    private String password;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public NoticeRequestDto(String title, String writer, String content, String password,Category category , LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.title= title;
        this.writer=writer;
        this.content=content;
        this.password=password;
        this.category=category;
        this.createdAt=createdAt;
        this.modifiedAt=modifiedAt;
    }
}
