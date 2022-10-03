package com.sparta.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {
        private final LocalDateTime timestamp = LocalDateTime.now();
        private Integer code;
        private HttpStatus httpStatus;
        private boolean success;
        private  String error;
        private List<Object> data;
}
