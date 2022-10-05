package com.sparta.homework.repository;

import com.sparta.homework.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Object> findAllByOrderByCreatedAtDesc();
    List<Object> findAllByTitleContaining(String title);
    List<Notice> findAllByTitleContains(String title);
    List<Notice> findByTitleIsContaining(String title);
}

