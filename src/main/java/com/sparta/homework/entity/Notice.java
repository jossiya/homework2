package com.sparta.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.homework.dto.NoticeRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Builder
@NoArgsConstructor // 기본생성자를 만듭니다.
@AllArgsConstructor
@Table
@Getter
@Entity
public class Notice extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Category category;


    public Notice(String title, String writer,String content, Category category,String password){
        this.title=title;
        this.writer=writer;
        this.content=content;
        this.password=password;
        this.category=category;


    }
    public Notice (NoticeRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
        this.category=requestDto.getCategory();
        setCreatedAt(getCreatedAt());
        setModifiedAt(getModifiedAt());

    }

    public void update(NoticeRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
