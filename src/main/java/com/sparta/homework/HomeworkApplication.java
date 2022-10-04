package com.sparta.homework;

import com.sparta.homework.entity.Notice;
import com.sparta.homework.repository.NoticeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(NoticeRepository noticeRepository) {
		return (args) -> {
			noticeRepository.save(new Notice("안녕하세요", "조정민" , "스프링 어려워","1234" ));
		};
	}
}
