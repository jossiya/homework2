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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public Notice(String title, String writer,String content, String password){
        this.title=title;
        this.writer=writer;
        this.content=content;
        this.password=password;


    }
    public Notice (NoticeRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
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
