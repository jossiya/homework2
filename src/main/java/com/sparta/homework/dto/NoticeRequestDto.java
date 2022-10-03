package com.sparta.homework.dto;

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

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public NoticeRequestDto(String title, String writer, String content, String password,  LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.title= title;
        this.writer=writer;
        this.content=content;
        this.password=password;
        this.createdAt=createdAt;
        this.modifiedAt=modifiedAt;
    }
}
