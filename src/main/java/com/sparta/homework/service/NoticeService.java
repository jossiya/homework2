package com.sparta.homework.service;

import com.sparta.homework.dto.NoticeRequestDto;
import com.sparta.homework.entity.Notice;
import com.sparta.homework.entity.ResultResponse;
import com.sparta.homework.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private ResultResponse resultResponse;

    public  ResponseEntity response(List<Object> data){

        resultResponse=ResultResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .success(HttpStatus.OK.is2xxSuccessful())
                .data(data)
                .error(null)
                .build();
        return new ResponseEntity(resultResponse ,resultResponse.getHttpStatus());
    }

    //모든 게시물,String category
    @Transactional
    public ResponseEntity findAllNotice(Integer display){
        int i;
        ArrayList<Object> search= new ArrayList<>();
        List<Object>list=noticeRepository.findAllByOrderByCreatedAtDesc();
        if (display!=0) {
            for (i = 0; i < list.size() - 1; i++) {
                if (i == display) break;
                search.add(list.get(i));
            }
            return response(search);
        } else {
            return response(noticeRepository.findAllByOrderByCreatedAtDesc());
        }
    }
    //게시물 등록
    @Transactional
    public ResponseEntity noticeSave(NoticeRequestDto requestDto){
        Notice notice=new Notice(requestDto);
        return response(Collections.singletonList(noticeRepository.save(notice)));
    }
    //게시물 삭제
    @Transactional
    public ResponseEntity noticeDelete(Long id){
        Notice notice = noticeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "존재하지 않는 아이디입니다.")
        );
        noticeRepository.deleteById(id);
        return response(Collections.singletonList(HttpStatus.OK.is2xxSuccessful()));
    }
    //게시물 수정
    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason ="존재하지 않는 아이디입니다." )
    @Transactional
    public ResponseEntity update(Long id, NoticeRequestDto requestDto) {
        Notice notice = noticeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "존재하지 않는 아이디입니다.")
        );

        notice.update(requestDto);
        return response(Collections.singletonList(notice));
    }
    //비밀번호 비교
    @Transactional
    public ResponseEntity compare(Long id, NoticeRequestDto requestDto){

        Notice notice = noticeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "존재하지 않는 아이디입니다.")
        );

        if(requestDto.getPassword().equals(notice.getPassword())){


            return response(Collections.singletonList(HttpStatus.OK.is2xxSuccessful()));
        }else {

            return response(Collections.singletonList(HttpStatus.OK.is2xxSuccessful()));
        }
    }
}
