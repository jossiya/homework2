package com.sparta.homework.controller;

import com.sparta.homework.dto.NoticeRequestDto;
import com.sparta.homework.repository.NoticeRepository;
import com.sparta.homework.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class NoticeController {
    private final NoticeRepository noticeRepository;
    private  final NoticeService noticeService;


    //모든 게시글 불러오기, @PathVariable String category
    @GetMapping(value={"/api/notices", "/api/notices/{category:[a-zA-Z]*$}" })
    @Validated
    public ResponseEntity getNotice(@RequestParam(value = "display", required = false, defaultValue = "0")  Integer display,
                                    @PathVariable(value = "category", required = false) String category
    ){
        System.out.println(category);
         return noticeService.findAllNotice(display);
    }

    //게시글 생성
    @PostMapping("/api/notices")
    public ResponseEntity creatNotice(@RequestBody NoticeRequestDto requestDto){
//        Notice notice=new Notice(requestDto);
//        return noticeRepository.save(notice);
        return noticeService.noticeSave(requestDto);
    }
    //게시글 수정
    @PutMapping("/api/notices/{id}")
    public ResponseEntity updateNotice(@PathVariable Long id ,@RequestBody NoticeRequestDto requestDto){
        return noticeService.update(id,requestDto);
    }
    //게시글 삭제
    @DeleteMapping("/api/notices/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id){
//        noticeRepository.deleteById(id);
        return noticeService.noticeDelete(id);
    }
    //게시글 하나 가져오기
    @GetMapping("/api/notices/{id:[0-9]*$}")
    //:[0-9]*$
    public ResponseEntity getNoticeOne(@PathVariable Long id){
        System.out.println(id);
        return noticeService.response(Collections.singletonList(noticeRepository.findById(id).get()));
    }
    //비밀번호 비교하기
    @PostMapping("/api/notices/{id:[0-9]*$}")
    public ResponseEntity confirmPasswerd(@PathVariable Long id, @RequestBody NoticeRequestDto requestDto){
        return noticeService.compare(id,requestDto);
    }
}
